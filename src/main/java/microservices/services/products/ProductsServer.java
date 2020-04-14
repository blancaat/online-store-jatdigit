package microservices.services.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import microservices.products.ProductRepository;
import microservices.products.ProductsConfiguration;
import microservices.services.web.HomeController;

/**
 * Micro-service registered with the Eureka Server
 * @author Blanca AT
 */

@EnableDiscoveryClient
@EnableAutoConfiguration
@Import(ProductsConfiguration.class)

public class ProductsServer {

	@Autowired
	protected ProductRepository productRepository;
	/**
	 * Run the application using Spring Boot
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	
	public static void main(String[] args) {
		// Configuration according to products-server.yml
		System.setProperty("spring.config.name", "products-server");
		SpringApplication.run(ProductsServer.class, args);
	}

   
}
