package microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Hide the access to the microservice inside this local service.
 * 
 * @author Blanca AT
 */

@Service
public class WebProductsService {

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	private String serviceUrl;

	public WebProductsService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public Product findByName(String productName) {
		return restTemplate.getForObject(serviceUrl + "/products/{productName}",
				Product.class, productName);
	}
}