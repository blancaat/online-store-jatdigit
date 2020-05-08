package microservices.cart;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * Entity with JPA. Cart is stored in a H2 database.
 * 
 * @author Blanca AT
 **/

@Entity
@Table(name = "T_CART")
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "ID")
	protected int id;
	
	/* Entire products will not be stored in the cart DB, but ther ID (name) and the quantity added to the
	 * cart will be stored
	 */
	
	@ElementCollection
	@CollectionTable(name="CART_PRODUCTS", joinColumns = @JoinColumn(name = "cart_id"))
	// Key: Name of Product; Value: Quantity of products 
	protected Map<String, String> products = new HashMap<String, String>();
	
	public Cart() {
		
	}
	
	public Cart(int id) {
		this.id = id;
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

	public void setProducts(Map<String, String> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + products + "]";
	}
	

}
