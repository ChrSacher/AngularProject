package BackendSpring.user.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;


import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    void delete(User user);

    List<User> findAll();

    User findByid(Long id); 
    
    User save(User user);
}