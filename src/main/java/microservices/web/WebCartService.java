package microservices.web;

import java.util.ArrayList;

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
	private RestTemplate restTemplate;

	private String serviceUrl;


	public WebCartService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
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