package microservices.services.web;

import java.util.ArrayList;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Cart DTO - used to interact with the {@link WebCartService}.
 * 
 * @author Blanca AT
 */

@JsonRootName("Cart")
public class Cart {
	protected int id;
	protected ArrayList<String> products;
	
	protected Cart() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + products + "]";
	}
	
}
