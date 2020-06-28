package microservices.products;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity with JPA. Products are stored in an H2 relational database.
 * 
 * @author Blanca AT
 */

@Entity
@Table(name = "T_PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DETAILS")
	private String details;
	
	@Column(name = "MEASURE")
	private String measure;
	
	@Column(name = "COLLECTION")
	private String collection;
	
	

	/**
	 * Default constructor for JPA only.
	 */
	public Product() {
		
	}

	public Product(String name, String title, int quantity, double price, String description, String details,
			String measure, String collection) {
		super();
		this.name = name;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.details = details;
		this.measure = measure;
		this.collection = collection;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", title=" + title + ", quantity=" + quantity + ", price=" + price
				+ ", description=" + description + ", details=" + details + ", measure=" + measure + ", collection="
				+ collection + "]";
	}	
}
