package microservices.services.web;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Cart DTO - used to interact with the {@link WebCartService}.
 * 
 * @author Blanca AT
 */

@JsonRootName("Cart")
public class Cart {
	protected int id;
	protected Map<String, String> products;
	
	protected Cart() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, String> getProducts() {
		return products;
	}

	public void setProducts(Map<String, String>products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + products + "]";
	}
	
}
