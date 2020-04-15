package microservices.services.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Online-store web-server. Works as a microservice client, fetching data from the
 * rest of microservices. Uses the Discovery Server (Eureka) to find them.
 * 
 * @author Blanca AT
 */

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, //
        DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class WebServer {

    /**
     * URL uses the logical name of products-service - upper or lower case, doesn't
     * matter.
     */
    public static final String PRODUCTS_SERVICE_URL = "http://PRODUCTS-SERVICE";

    /**
     * Run the application using Spring Boot
     * 
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
		// Configuration according to web-server.yml
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(WebServer.class, args);
    }

    /**
     * A customized RestTemplate given by Spring to perform HTTP requests.
     * 
     * @return
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * The AccountService encapsulates the interaction with the micro-service.
     * 
     * @return A new service instance.
     */
    @Bean
    public WebAccountsService accountsService() {
        return new WebAccountsService(PRODUCTS_SERVICE_URL);
    }

    /**
     * Create the controller, passing it the {@link WebAccountsService} to use.
     * 
     * @return
     */
    @Bean
    public WebAccountsController accountsController() {
        return new WebAccountsController(accountsService());
    }

    @Bean
    public HomeController homeController() {
        return new HomeController();
    }
}