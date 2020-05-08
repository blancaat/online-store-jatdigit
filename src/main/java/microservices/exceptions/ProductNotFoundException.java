package microservices.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * Allow the controller to return a 404 if a product is not found 
 * 
 * @author Blanca AT
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String productName) {
		super("No se ha encontrado el producto: " + productName);
	}
}
