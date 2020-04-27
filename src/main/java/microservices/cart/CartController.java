package microservices.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * A RESTFul controller for accessing cart information.
 * 
 * @author Blanca AT
 */

@RestController
public class CartController {
	protected CartRepository cartRepository;

	/**
	 * Create an instance plugging in the repository of Cart.
	 * 
	 * @param productRepository
	 *           
	 */
	
	@Autowired
	public CartController(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	@RequestMapping("/cart")
	public Cart getCart() {
		Cart cart = cartRepository.findById(1);
		return cart;
	}
		
}
	
