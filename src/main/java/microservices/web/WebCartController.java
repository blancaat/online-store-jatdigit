package microservices.web;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private WebCartService cartService;
	private WebProductsService productsService;

	public WebCartController(WebCartService cartService, WebProductsService productsService) {
		this.cartService = cartService;
		this.productsService = productsService;
	}
	
	@RequestMapping("/cart")
	public String byCart(Model model) {
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Integer> quantities = new ArrayList<Integer>();
		
		// HTTP request to Cart Microservice
		Cart cart = cartService.showCart();
		
		// HTTP request to Product Microservice
		if (cart.getProducts() != null) { // If there are products in the cart
			for (Map.Entry<String, String> entry: cart.getProducts().entrySet()){ // Iterate the Map
				// Obtain the product thanks to the Product Service
				Product product = productsService.findByName(entry.getKey());
				int quantity = Integer.parseInt(entry.getValue());
				products.add(product);
				quantities.add(quantity);
			}
			// Products and quantities are sent in View for display to the user 
			model.addAttribute("products", products);	
			model.addAttribute("quantities", quantities);
			return "cart";	
			}
		else {
			return "cart-null";
		}
	}
	
	@RequestMapping(value = "/cart/add")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void addProduct(@RequestParam("quantity") String quant, @RequestParam("name")  String name) {
		// HTTP request to Cart Microservice
		// Cart microservice modify their stock
		cartService.addProduct(name, quant);	
	}
	
	@RequestMapping(value = "/cart/delete/{name}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable("name") String name) {
		// HTTP request to Cart Microservice
		// Cart microservice modify their stock
		cartService.deleteProduct(name);	
	}
}