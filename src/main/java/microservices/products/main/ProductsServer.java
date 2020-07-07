package microservices.products.main;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Import;

import microservices.products.ProductsConfiguration;

/**
 * Micro-service registered with the Eureka Server
 * @author Blanca AT
 */

@EnableDiscoveryClient
@EnableAutoConfiguration
@Import(ProductsConfiguration.class)

public class ProductsServer {

	/**
	 * Run the application using Spring Boot
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 * @throws UnknownHostException 
	 */
	
	public static void main(String[] args) {
		// Configuration according to products-server.yml
		System.setProperty("spring.config.name", "products-server");
		SpringApplication.run(ProductsServer.class, args);
	}
}
