package microservices.cart;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import java.io.Serializable;

/**
 * Singleton Entity with JPA. Cart is stored in a H2 database.
 * 
 * @author Blanca AT
 **/

@Entity
@Table(name = "T_CART")
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Cart cartInstance;
	
	@Id
	@Column (name = "ID")
	private int id = 1;
	
	@ElementCollection
	@CollectionTable(name="CART_PRODUCTS", joinColumns = @JoinColumn(name = "cart_id"))
	// Key: Name of Product; Value: Quantity of products 
	private Map<String, String> products;
	
	/**
	 * Default constructor for JPA only.
	 */
	public Cart() {
		
	}
	
	// Private constructor because is Singleton
	private Cart(Map<String, String> products) {
		this.products = products;
	}
	
	public static Cart getCartInstance() {
		if (cartInstance == null) {
			Map<String, String> products = new HashMap<>();		
			cartInstance = new Cart(products);
		}
		return cartInstance;
	}

	public Map<String, String> getProducts() {
		return products;
	}

	public void setProducts(Map<String, String> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}

}