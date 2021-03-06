//package BackendSpring.security.config;
//
//import java.util.Arrays;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.Resource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.init.DataSourceInitializer;
//import org.springframework.jdbc.datasource.init.DatabasePopulator;
//import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import BackendSpring.security.jwt.CustomTokenEnhancer;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    static final String CLIEN_ID = "devglan-client";
//    // static final String CLIENT_SECRET = "devglan-secret";
//    static final String CLIENT_SECRET = "$2a$04$e/c1/RfsWuThaWFCrcCuJeoyvwCV0URN/6Pn9ZFlrtIWaU/vj/BfG";
//    static final String GRANT_TYPE_PASSWORD = "password";
//    static final String AUTHORIZATION_CODE = "authorization_code";
//    static final String REFRESH_TOKEN = "refresh_token";
//    static final String IMPLICIT = "implicit";
//    static final String SCOPE_READ = "read";
//    static final String SCOPE_WRITE = "write";
//    static final String TRUST = "trust";
//    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
//    static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//	converter.setSigningKey("as466gf");
//	return converter;
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//	return new JwtTokenStore(accessTokenConverter());
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
//
//	configurer.inMemory().withClient(CLIEN_ID).secret(CLIENT_SECRET)
//		.authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT)
//		.scopes(SCOPE_READ, SCOPE_WRITE, TRUST).accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
//		.refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//	TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//	tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));
//
//	endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain)
//		.authenticationManager(authenticationManager);
//    }
//
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices() {
//	DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//	defaultTokenServices.setTokenStore(tokenStore());
//	defaultTokenServices.setSupportRefreshToken(true);
//	return defaultTokenServices;
//    }
//
//    @Bean
//    public TokenEnhancer tokenEnhancer() {
//	return new CustomTokenEnhancer();
//    }
//
//}