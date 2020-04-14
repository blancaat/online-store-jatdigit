package microservices.products;

import org.springframework.data.repository.Repository;
/**
 * Repository for Product data implemented using Spring Data JPA.
 * 
 * @author Blanca AT
 */
public interface ProductRepository extends Repository<Product, Long> {
	
	/**
	 * Find a product with the specified product name.
	 *
	 * @param productName
	 * @return The product if found, null otherwise.
	 */
	
	public Product findByName(String productName);
	
}
