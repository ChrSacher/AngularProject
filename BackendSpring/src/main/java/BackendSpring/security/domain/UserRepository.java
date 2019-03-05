package BackendSpring.security.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByUserName(String userName);
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    
    List<User> findAllByOrderByUserNameAsc();
}
