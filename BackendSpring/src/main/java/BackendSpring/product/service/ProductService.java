package BackendSpring.product.service;

import java.util.List;

import BackendSpring.product.domain.Product;
import BackendSpring.product.domain.ProductForm;

public interface ProductService {
    public List<Product> findAll();
    
    
    public Product findByid(Long id);  
     
    public Product save(Product product);
    public Product save(ProductForm productForm);
    public void delete(Product delete);
}
