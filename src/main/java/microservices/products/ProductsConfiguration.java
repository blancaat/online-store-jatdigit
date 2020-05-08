package microservices.products;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.io.IOException;

/**
 * The products Spring configuration.
 * 
 * @author Blanca AT
 */

@Configuration
@ComponentScan()
@EntityScan("microservices.products")
@EnableJpaRepositories("microservices.products")
@PropertySource("classpath:productDB-config.properties")
public class ProductsConfiguration {
	public ProductsConfiguration() {
	}

	/**
	 * Creates a database with data. 
	 * @throws IOException 
	 */
	
	@Bean
	public DataSource dataSource() throws IOException {
		// Create database T_PRODUCT and add data to Product Database using data.sql file
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:datadb/schemaProducts.sql")
				.addScript("classpath:datadb/dataProducts.sql").build();

		return dataSource;
	}
}
