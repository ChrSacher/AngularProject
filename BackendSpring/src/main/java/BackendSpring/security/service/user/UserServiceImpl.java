package BackendSpring.security.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import BackendSpring.security.domain.CurrentUser;
import BackendSpring.security.domain.User;
import BackendSpring.security.domain.UserCreateForm;
import BackendSpring.security.domain.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public  User getUserById(long id) {
        log.debug("Getting user={}", id);
        User user = userRepository.findById(id).orElseThrow(() -> 
		new NoSuchElementException(String.format(">>> User=%s not found", id)));
        return user;
    }
    
    @Override
    public User getUserByEmail(String email) {
        log.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findOneByEmail(email).orElseThrow(() -> 
	new NoSuchElementException(String.format(">>> User=%s not found", email)));
    }

    @Override
    public boolean existsByUserName(String nickname) {
        return userRepository.existsByUserName(nickname);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        log.debug("Getting all users");
        List<User> targetListOrigin = userRepository.findAllByOrderByUserNameAsc(); 
        return targetListOrigin;
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setNickname(form.getUserName());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
    @Override
    public User loadUserByUsername(String userName)
    {
	return userRepository.findOneByUserName(userName).orElseThrow(() -> 
	new NoSuchElementException(String.format(">>> User=%s not found", userName)));
    }

    @Override
    public boolean verifyCredentials(String password, String passwordHash) {
	return new BCryptPasswordEncoder().matches(password, passwordHash);
    }

}
