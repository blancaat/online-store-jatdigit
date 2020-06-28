package microservices.cart;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Cart data implemented using Spring Data JPA
 * 
 * @author Blanca AT
 */


public interface CartRepository extends JpaRepository<Cart,Integer> {}