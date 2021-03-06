package BackendSpring.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    
    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authManager) {
	super("/api/secure/**");
	setAuthenticationManager(authManager);

    }

    public JwtAuthenticationFilter(AuthenticationManager authManager, RequestMatcher matcher) {
	super(matcher);
	setAuthenticationManager(authManager);

    }

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return super.requiresAuthentication(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
	    throws AuthenticationException {

	String header = request.getHeader(jwtProperties.getJwtHeader());

	if (header == null || !header.startsWith(jwtProperties.getJwtSchema())) {
	    throw new JwtTokenMissingException("No JWT token found in request headers");
	}

	String authToken = header.substring(jwtProperties.getJwtSchema().length());

	JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

	return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
	    Authentication authResult) throws IOException, ServletException {
	super.successfulAuthentication(request, response, chain, authResult);

	// As this authentication is in HTTP header, after success we need to continue
	// the request normally
	// and return the response as if the resource was not secured at all
	chain.doFilter(request, response);
    }
}