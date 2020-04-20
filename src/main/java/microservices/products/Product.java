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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NAME")
	protected String name;
	
	@Column(name = "TITLE")
	protected String title;
	
	@Column(name = "PRICE")
	protected int price;
	
	@Column(name = "DESCRIPTION")
	protected String description;
	
	@Column(name = "DETAILS")
	protected String details;
	
	@Column(name = "MEASURE")
	protected String measure;
	

	/**
	 * Default constructor for JPA only.
	 */
	protected Product() {
		
	}

	public Product(String name, String title, int price, String description, String details,
			String measure) {
		super();
		this.name = name;
		this.title = title;
		this.price = price;
		this.description = description;
		this.details = details;
		this.measure = measure;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	@Override
	public String toString() {
		return "Product [name=" + name + ",title=" + title + ", price=" + price + ", description="
				+ description + ", details=" + details + ", measure=" + measure + "]";
	}	

}
