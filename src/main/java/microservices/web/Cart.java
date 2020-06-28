package microservices.web;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Cart Data Transfer Object. Transfer data between processes
 * used to interact with the {@link WebCartService}.
 * 
 * 
 * @author Blanca AT
 */

@JsonRootName("Cart")
public class Cart {
	private Map<String, String> products;
	
	/**
	 * Default constructor only for JPA.
	 */
	public Cart() {}
	
	
	public Map<String, String> getProducts() {
		return products;
	}

	public void setProducts(Map<String, String>products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}
}
