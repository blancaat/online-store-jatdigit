package microservices.cart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/**
	 * Return the cart 
	 * 
	 * @return The cart if found.
	 */
	
	@RequestMapping("/cart")
	public Cart getCart() {
		Cart cart = cartRepository.findById(1);
		return cart;
	}
	
	/**
	 * Add a product to the cart.
	 * 
	 * @param name
	 * 
	 */
	
	@PostMapping("/cart/add")
	public void addProduct(@RequestBody ArrayList<String> data) {
		Cart cart = cartRepository.findById(1);
		String name = data.get(0); // key
		String quantity = data.get(1); // value
		cart.getProducts().put(name, quantity);	
		cartRepository.save(cart);
	}
	
	/**
	 * Remove a product from the cart.
	 * 
	 * @param name
	 * 
	 */
	@PostMapping("/cart/delete")
	public void deleteProduct(@RequestBody String name) {
		Cart cart = cartRepository.findById(1);
		cart.getProducts().remove(name);	
		cartRepository.save(cart);
	}
			
}
