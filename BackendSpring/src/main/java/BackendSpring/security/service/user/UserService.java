package BackendSpring.security.service.user;


import java.util.Collection;
import java.util.Optional;

import BackendSpring.security.domain.CurrentUser;
import BackendSpring.security.domain.User;
import BackendSpring.security.domain.UserCreateForm;
import BackendSpring.security.service.dto.UserDTO;


public interface UserService {

	UserDTO getUserById(long id);
	Optional<User> getUserByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
    Collection<UserDTO> getAllUsers();
    User create(UserCreateForm form);
    public  Optional<CurrentUser> getCurrentUser() ;
}
