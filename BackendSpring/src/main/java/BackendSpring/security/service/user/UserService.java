package BackendSpring.security.service.user;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import BackendSpring.security.domain.CurrentUser;
import BackendSpring.security.domain.User;
import BackendSpring.security.domain.UserCreateForm;


public interface UserService {

    User getUserById(long id);

    User getUserByEmail(String email);

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);

    User create(UserCreateForm form);

    public List<User> getAllUsers();
    
    User loadUserByUsername(String userName);

    boolean verifyCredentials(String password, String passwordHash);

}
