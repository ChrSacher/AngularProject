package BackendSpring.security.jwt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import BackendSpring.security.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenGenerator {
    @Autowired
    private JwtProperties jwtProperties;

    public String generateToken(User u) {

	Claims claims = Jwts.claims().setSubject(u.getUserName());
	claims.put("userId", u.getId() + "");
	claims.put("role", u.getRole());

	LocalDateTime oneDayFromNow = LocalDateTime.now().plusHours(jwtProperties.getValidHours());
	Date expirationDate = Date.from(oneDayFromNow.atZone((ZoneId.systemDefault())).toInstant());

	return Jwts.builder().setClaims(claims).setExpiration(expirationDate)
		.signWith(SignatureAlgorithm.HS512, jwtProperties.getJwtSecret()).compact();
    }
}
