package BackendSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import BackendSpring.developer.service.DeveloperService;
import BackendSpring.developer.service.UserAllreadyExistsException;
import BackendSpring.security.domain.Role;
import BackendSpring.security.domain.User;
import BackendSpring.security.domain.UserCreateForm;
import BackendSpring.security.service.user.UserService;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;

@Component
public class InitializeDB
{

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);
    
    @Autowired
    private UserService userService;
   
    @Autowired
    private DeveloperService devService;
    @PostConstruct
    public void init()
    {

	log.debug(" >>> Db initialized");

	DateTimeFormatter germanFormatter = ofLocalizedTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
	String s = LocalTime.now().minusMinutes(10).format(germanFormatter);
	UserCreateForm x = new UserCreateForm();
	x.setEmail("zwegat@email.de");
	x.setPassword("test");
	x.setPasswordRepeated("test");
	x.setUserName("Zwegat");
	x.setRole(Role.ADMIN);
	
	try {
	    userService.create(x);
	    devService.createDeveloper(x);
	} catch (UserAllreadyExistsException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
