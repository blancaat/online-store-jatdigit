package microservices.cart;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Cart data implemented using Spring Data JPA
 * 
 * @author Blanca AT
 */


public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	/**
	 * Find a cart with the specified cart name.
	 *
	 * @param id
	 * @return The cart if found, null otherwise.
	 */
	Cart findById(int id);
	
}
