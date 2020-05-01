package microservices.cart;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * The Cart Spring configuration.
 * 
 * @author Blanca AT
 */
@Configuration
@ComponentScan()
@EntityScan("microservices.cart")
@EnableJpaRepositories("microservices.cart")
@PropertySource("classpath:cartDB-config.properties")
public class CartConfiguration {
	public CartConfiguration() {
	}
	
}
