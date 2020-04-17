package microservices.services.web;


import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Product DTO - used to interact with the {@link WebProductsService}.
 * 
 * @author Blanca AT
 */

@JsonRootName("Product")
public class Product {

	protected String name;
	protected String image;
	

	/**
	 * Default constructor for JPA only.
	 */
	protected Product() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", image=" + image + "]";
	}

}
