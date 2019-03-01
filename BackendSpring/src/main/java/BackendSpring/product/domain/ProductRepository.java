package BackendSpring.product.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Long>{

   public List<Product> findAll();
   
     
   public Product findByid(Long id);  
    
   public Product save(Product product);
   
   public void delete(Product delete);

}
