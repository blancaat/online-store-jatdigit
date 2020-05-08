package microservices.services.web;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebCartService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebCartService.class
			.getName());

	public WebCartService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory().getClass());
	}
	
	public Cart showCart() {
		// GET Request to the URL specified by RestTemplate. Obtains the Cart Product
		return restTemplate.getForObject(serviceUrl + "/cart",
				Cart.class);
	}
	
	public void addProduct(String name, String quant) {
		/* POST Request to the URL specified by RestTemplate. Send an ArrayList of data containing
		 * the name and quantity of the product to be added to the cart 
		 */
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ArrayList<String> data = new ArrayList<String>();
		data.add(name);
		data.add(quant);
		
		HttpEntity<ArrayList<String>> request = new HttpEntity<ArrayList<String>>(data, headers);
		// Send to Cart Controller POST ArrayList Object
		restTemplate.postForObject(serviceUrl + "/cart/add", request, ArrayList.class);	
	}
	
	
	public void deleteProduct(String name) {
		/* POST Request to the URL specified by RestTemplate. Send the name of the product to be 
		 * deleted in the cart */
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		HttpEntity<String> request = new HttpEntity<String>(name, headers);
		
		// Send to Cart Controller POST String object
		restTemplate.postForLocation(serviceUrl + "/cart/delete", request);
	}
	
}
