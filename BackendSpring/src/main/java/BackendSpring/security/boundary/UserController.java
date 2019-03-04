package BackendSpring.security.boundary;

import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BackendSpring.developer.service.DeveloperService;
import BackendSpring.developer.service.UserAllreadyExistsException;
import BackendSpring.security.domain.User;
import BackendSpring.security.domain.UserCreateForm;
import BackendSpring.security.jwt.JwtToken;
import BackendSpring.security.jwt.JwtTokenGenerator;
import BackendSpring.security.jwt.JwtTokenRequest;
import BackendSpring.security.service.user.UserService;
import BackendSpring.security.service.validator.UserCreateFormValidator;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private DeveloperService developerService;
    private UserCreateFormValidator userCreateFormValidator;
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator,
	    DeveloperService developerService,JwtTokenGenerator jwtTokenGenerator ) {
	this.userService = userService;
	this.userCreateFormValidator = userCreateFormValidator;
	this.developerService = developerService;
	this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @InitBinder("UserCreateForm")
    public void initBinder(WebDataBinder binder) {
	binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public JwtToken jsonLogin(@RequestBody JwtTokenRequest credentials) {

	JwtToken response = new JwtToken();

	User userDetails = userService.loadUserByUsername(credentials.getUsername());

	if (userDetails == null) {
	    response.setError("Bad credentials");
	    return response;
	}

	if (userService.verifyCredentials(credentials.getPassword(), userDetails.getPasswordHash())) {
	    // Generate valid token
	    String token = jwtTokenGenerator.generateToken(userDetails);
	    response.setToken(token);
	} else {
	    response.setError("Bad credentials");
	}

	return response;
    }
    // // PreAuthorize("hasAuthority('ADMIN')")
    // @Transactional
    // @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    // public String handleUserCreateForm(@Valid @ModelAttribute("UserCreateForm")
    // UserCreateForm form,
    // BindingResult bindingResult, Model model, HttpServletRequest request) {
    // log.info("Processing user create form= " + form + " bindingResult= " +
    // bindingResult);
    // if (bindingResult.hasErrors())
    // {
    // model.addAttribute("UserCreateForm", form);
    // model.addAttribute("error",
    // bindingResult.getGlobalError().getDefaultMessage());
    // throw new RuntimeException();
    // }
    //
    // try {
    // userService.create(form);
    // developerService.createDeveloper(form);
    // } catch (UserAllreadyExistsException e1) {
    // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    // }
    //
    // try {
    // request.login(form.getEmail(), form.getPassword());
    // } catch (ServletException e) {
    //
    // }
    // return "";
    //
    // }
    //
    //
    // @PreAuthorize("hasAuthority('ADMIN')")
    // @RequestMapping("/users")
    // public String getUsersPage(Model model) {
    // log.info("Getting users page");
    // model.addAttribute("users", userService.getAllUsers());
    // return "users";
    // }
    //
    // @PreAuthorize("#id == principal.id or hasAuthority('ADMIN')")
    // @RequestMapping(value = "/users/{id}", method = { RequestMethod.POST,
    // RequestMethod.GET })
    // public String getUserPage(@PathVariable Long id, Model model) {
    // log.debug("Getting user page for user= " + id);
    // UserDTO userDTO = userService.getUserById(id);
    // model.addAttribute("user", userDTO);
    // model.addAttribute("fromUser", userDTO.getNickname());
    // return "user";
    // }
    //
    // @PreAuthorize("hasAuthority('ADMIN')")
    // @RequestMapping(value = "/users/managed", method = { RequestMethod.POST,
    // RequestMethod.GET })
    // public String getUserManagedPage(Model model) {
    // log.debug("Getting user create form");
    // model.addAttribute("UserCreateForm", new UserCreateForm());
    // model.addAttribute("users", userService.getAllUsers());
    // return "user_create";
    // }

}
