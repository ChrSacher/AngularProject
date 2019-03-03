package BackendSpring.developer.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface DeveloperRepository extends JpaRepository<Developer,Long>{
    public List<Developer> findAll();
    
    
    public Optional<Developer> findByid(Long id);  
    public Optional<Developer> findByemail(String email);  
    public Optional<Developer> findByuserName(String userName);  
    public Developer save(Developer developer);
    
    public void delete(Developer delete);
}
