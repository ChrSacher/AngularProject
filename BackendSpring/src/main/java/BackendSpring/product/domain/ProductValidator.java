package BackendSpring.product.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
	return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object arg0, Errors arg1) {
	// TODO Auto-generated method stub

    }

}
