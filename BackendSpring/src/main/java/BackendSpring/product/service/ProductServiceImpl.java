package BackendSpring.product.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import BackendSpring.product.domain.Product;
import BackendSpring.product.domain.ProductForm;
import BackendSpring.product.domain.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository pRep;
    
    @Override
    public List<Product> findAll() {
	return pRep.findAll();
    }

    @Override
    public Product findByid(Long id) {
	return pRep.findByid(id);
    }
    
    public Product save(ProductForm productForm)
    {
	Product product = new Product();
	BeanUtils.copyProperties(productForm, product);
	return pRep.save(product);
    }
    @Override
    public Product save(Product product) {
	return pRep.save(product);
    }

    @Override
    public void delete(Product delete) {
	pRep.delete(delete);

    }

}
