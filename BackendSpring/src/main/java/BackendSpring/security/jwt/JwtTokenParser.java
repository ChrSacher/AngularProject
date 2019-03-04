package BackendSpring.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import BackendSpring.security.domain.Role;
import BackendSpring.security.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenParser {

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * Tries to parse specified String as a JWT token. If successful, returns User
     * object with username, id and role prefilled (extracted from token). If
     * unsuccessful (token is invalid or not containing all required user
     * properties), simply returns null.
     * 
     * @param token
     *            the JWT token to parse
     * @return the User object extracted from specified token or null if a token is
     *         invalid.
     */
    public User parseToken(String token) {
	try {
	    Claims body = Jwts.parser().setSigningKey(jwtProperties.getJwtSecret()).parseClaimsJws(token).getBody();

	    User u = new User();
	    u.setNickname(body.getSubject());
	    u.setId(Long.parseLong((String) body.get("userId")));
	    String role = (String) body.get("role");
	    if (role.equals("ADMIN")) {
		u.setRole(Role.ADMIN);
	    } else {
		if (role.equals("USER")) {
		    u.setRole(Role.USER);
		} else
		    throw new JwtException("Role is malformed");
	    }

	    return u;

	} catch (JwtException | ClassCastException e) {
	    return null;
	}
    }

}
