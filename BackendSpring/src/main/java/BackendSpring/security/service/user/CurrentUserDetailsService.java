package BackendSpring.security.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import BackendSpring.security.domain.CurrentUser;
import BackendSpring.security.domain.User;

@Service(value = "userService")
public class CurrentUserDetailsService implements UserDetailsService
{
	 private static final Logger log = LoggerFactory.getLogger(CurrentUserDetailsService.class);

	private UserService userService;

	@Autowired
	public CurrentUserDetailsService(UserService userService)
	{
	    	log.debug("test");
		this.userService = userService;
	}

	@Override
	public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException
	{
		log.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
		
		User user = userService.getUserByEmail(email);
				
		return new CurrentUser(user);
	}
}
