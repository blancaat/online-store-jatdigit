package microservices.services.web;


import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Product DTO - used to interact with the {@link WebProductsService}.
 * 
 * @author Blanca AT
 */

@JsonRootName("Product")
public class Product {

	protected String name;
	protected String title;
	protected int quantity;
	protected double price;
	protected String description;
	protected String details;
	protected String measure;
	protected String collection;


	/**
	 * Default constructor for JPA only.
	 */
	

	protected Product() {
		
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
		return name;
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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
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
