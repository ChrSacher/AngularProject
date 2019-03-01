package BackendSpring.security.boundary;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import BackendSpring.developer.domain.Developer;
import BackendSpring.developer.service.DeveloperService;

import BackendSpring.security.domain.CurrentUser;
import BackendSpring.security.domain.CurrentUserDTO;

@ControllerAdvice
public class CurrentUserControllerAdvice
{
    @Autowired
    private DeveloperService developerService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserControllerAdvice.class);

    @ModelAttribute("CurrentUserInfo")
    public CurrentUserDTO getCurrentUser(Authentication authentication) throws UsernameNotFoundException
    {
	CurrentUser user = (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
	if (user != null)
	{
	    Optional<Developer> cus = developerService.getCurrentCustomer();
	    if (cus.isPresent())
	    {
		return new  CurrentUserDTO(cus.get(),user.getEmail(),true);
	    }

	}
	return new  CurrentUserDTO(null,"",false);
	
    }

}
