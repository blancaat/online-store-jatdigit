package microservices.cart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;



import microservices.services.web.*;
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
	
	@ElementCollection
	@CollectionTable(name="CART_PRODUCTS", joinColumns = @JoinColumn(name = "cart_id"))
	protected Set<String> products = new HashSet<>();
	
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

	public Set<String> getProducts() {
		return products;
	}

	public void setProducts(Set<String> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + products + "]";
	}
	

}
