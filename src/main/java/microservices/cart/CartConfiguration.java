package microservices.cart;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
@ComponentScan()
@EntityScan("microservices.cart")
@EnableJpaRepositories("microservices.cart")
@PropertySource("classpath:cartDB-config.properties")
public class CartConfiguration {
	public CartConfiguration() {
	}
	
	
}
