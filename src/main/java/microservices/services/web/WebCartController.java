package microservices.services.web;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


/**
 * Client controller, fetches Cart info from the microservice via
 * {@link WebCartService}.
 * 
 * @author Blanca AT
 */

@Controller
public class WebCartController {

	@Autowired
	protected WebCartService cartService;
	protected WebProductsService productsService;


	protected Logger logger = Logger.getLogger(WebProductsController.class
			.getName());

	public WebCartController(WebCartService cartService, WebProductsService productsService) {
		this.cartService = cartService;
		this.productsService = productsService;
	}
	
	@RequestMapping("/cart")
	public String byCart(Model model) {
		ArrayList<Product> products = new ArrayList<Product>();
		// HTTP request to Cart Microservice
		Cart cart = cartService.showCart();
		// HTTP request to Product Microservice
		if (cart.getProducts() != null) { // If there are products in the cart
			for (int i = 0; i < cart.getProducts().size(); i++) {
				Product product = productsService.findByName(cart.getProducts().get(i));
				products.add(product);
			}
			model.addAttribute("products", products);		
			return "cart";
		}
		else {
			return "cart-null";
		}
	}
	
	@RequestMapping(value = "/cart/add/{name}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void addProductToCart(@PathVariable("name") String name) {
		// HTTP request to Cart Microservice
		String productName = name;

		// Cart microservice modify their stock
		cartService.addProduct(productName);	
	}
	
	@RequestMapping(value = "/cart/delete/{name}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable("name") String name) {
		// HTTP request to Cart Microservice
		String productName = name;

		// Cart microservice modify their stock
		cartService.deleteProduct(productName);	
	}
}
