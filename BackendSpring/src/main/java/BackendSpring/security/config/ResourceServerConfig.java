package BackendSpring.security.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import BackendSpring.security.jwt.CustomAccessTokenConverter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
	resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
	http.anonymous().disable().authorizeRequests().antMatchers("**").access("hasRole('ADMIN')").and()
		.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

    @Autowired
    private CustomAccessTokenConverter customAccessTokenConverter;

    @Bean
    public TokenStore resourceTokenStore() {
	return new JwtTokenStore(resourceAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter  resourceAccessTokenConverter() {
	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	converter.setAccessTokenConverter(customAccessTokenConverter);
	return converter;
    }
    
    
    public Map<String, Object> getExtraInfo(Authentication auth) {
	    OAuth2AuthenticationDetails oauthDetails
	      = (OAuth2AuthenticationDetails) auth.getDetails();
	    return (Map<String, Object>) oauthDetails
	      .getDecodedDetails();
	}
}