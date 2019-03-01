package BackendSpring.product.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSpring.product.domain.Product;
import BackendSpring.product.domain.ProductForm;
import BackendSpring.product.service.ProductService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/product" })
public class ProductController
{
    @Autowired
    private ProductService pService;

    @PostMapping
    public Product create(@RequestBody ProductForm product)
    {
	System.out.println("test");
        return pService.save(product);
    }

    @GetMapping(path = {"/{id}"})
    public Product findOne(@PathVariable("id") Long id){
        return pService.findByid(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return pService.save(product);
    }

    @DeleteMapping(path ={"/{id}"})
    public Product delete(@PathVariable("id") Long id) {
	Product product = pService.findByid(id);
	pService.delete(product);
        return product;
    }

    @GetMapping
    public List<Product> findAll(){
        return pService.findAll();
    }
}
