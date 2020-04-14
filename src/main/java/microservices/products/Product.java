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

	@Column(name = "IMAGE")
	protected String image;

	/**
	 * Default constructor for JPA only.
	 */
	protected Product() {
		
	}

	public Product(String name, String image) {
		this.name = name;
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [mName=" + name + ", mImage=" + image + "]";
	}


}
