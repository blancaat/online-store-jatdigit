package microservices.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/cart/add")
	public void addProduct(@RequestBody String name) {
		System.out.println("desde Cart Controller " + name);
		Cart cart = cartRepository.findById(1);
		cart.getProducts().add(name);	
		cartRepository.save(cart);
	}
	
	@RequestMapping("/cart/delete")
	public void deleteProduct(String name) {
		Cart cart = cartRepository.findById(1);
		cart.getProducts().remove(name);
				
	}
				
}
	
	
	
	
	
