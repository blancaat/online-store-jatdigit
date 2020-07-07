package microservices.cart.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import microservices.cart.Cart;
import microservices.cart.CartConfiguration;
import microservices.cart.CartRepository;

/**
 * Micro-service registered with the Eureka Server
 * @author Blanca AT
 */

@EnableDiscoveryClient
@EnableAutoConfiguration
@Import(CartConfiguration.class)
public class CartServer implements CommandLineRunner{

	@Autowired
	private CartRepository cartRepository;
	/**
	 * Run the application using Spring Boot
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 * @throws UnknownHostException 
	 */
	
	public static void main(String[] args) {
		// Configuration according to cart-server.yml
		System.setProperty("spring.config.name", "cart-server");
		SpringApplication.run(CartServer.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create the Cart Singleton Object
		cartRepository.deleteAll();		
		Cart cart = Cart.getCartInstance();
		cartRepository.save(cart);	
	}}