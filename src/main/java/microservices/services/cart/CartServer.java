package microservices.services.cart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import microservices.services.web.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Import;

import microservices.cart.CartRepository;
import microservices.cart.Cart;
import microservices.cart.CartConfiguration;;

/**
 * Micro-service registered with the Eureka Server
 * @author Blanca AT
 */

@EnableDiscoveryClient
@EnableAutoConfiguration
@Import(CartConfiguration.class)
public class CartServer implements CommandLineRunner{

	@Autowired
	protected CartRepository cartRepository;
	/**
	 * Run the application using Spring Boot
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	
	public static void main(String[] args) {
		// Configuration according to cart-server.yml
		System.setProperty("spring.config.name", "cart-server");
		SpringApplication.run(CartServer.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crate the cart store
		cartRepository.deleteAll();
		Set<String> products = new HashSet<String>();
		products.add("diagonal-square");
		products.add("voronoi");
		products.add("grid"); 
		Cart cart = new Cart(1);
		cart.setProducts(products);
		cartRepository.save(cart);	
	}}