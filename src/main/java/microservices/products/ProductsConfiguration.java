package microservices.products;


import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.util.List;
import ch.qos.logback.classic.Logger;

/**
 * The products Spring configuration.
 * 
 * @author Blanca AT
 */

@Configuration
@ComponentScan({"microservices.products.*"})
@EntityScan("microservices.products")
@EnableJpaRepositories("microservices.products")
@PropertySource("classpath:db-config.properties")
public class ProductsConfiguration {
	public ProductsConfiguration() {
	}

	/**
	 * Creates a database with data. 
	 */
	
	@Bean
	public DataSource dataSource() {
		// Create database T_PRODUCT and add data to Product Database using data.sql file
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql").build();

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> products = jdbcTemplate.queryForList("SELECT * FROM T_PRODUCT");
		System.out.println("Numero de productos"  + products.size());
		System.out.println(products.get(0));
		return dataSource;
	}
}
