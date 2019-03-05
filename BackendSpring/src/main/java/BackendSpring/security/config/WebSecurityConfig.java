package BackendSpring.security.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import BackendSpring.security.jwt.JwtAuthenticationFilter;
import BackendSpring.security.jwt.JwtAuthenticationProvider;
import BackendSpring.security.jwt.JwtAuthenticationSuccessHandler;
import BackendSpring.security.service.user.CurrentUserDetailsService;

@Order(2)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "userService")
    private CurrentUserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("resources/**");
    }

    @Autowired
    private JwtAuthenticationSuccessHandler successHandler;
    @Autowired
    private JwtAuthenticationProvider provider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

	JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(authenticationManager(),new AntPathRequestMatcher("/api/secure/**"));
	jwtAuthFilter.setAuthenticationSuccessHandler(successHandler);

	http.antMatcher("**") //
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).anonymous().and().csrf()
		.disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    @Bean(name = "myAuthenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
}
