package microservices.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import microservices.exceptions.ProductNotFoundException;

/**
 * A RESTFul controller for accessing product information.
 * 
 * @author Blanca AT
 */

@RestController
public class ProductsController {

	
	protected ProductRepository productRepository;

	/**
	 * Create an instance plugging in the repository of Products.
	 * 
	 * @param productRepository
	 *           
	 */
	
	@Autowired
	public ProductsController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/**
	 * Fetch a product with the specified product name.
	 * 
	 * @param productName
	 * @return The product if found.
	 * @throws ProductNotFoundException
	 *             If the name is not recognised.
	 */
	
	@RequestMapping("/products/{productName}")
	public Product byName(@PathVariable("productName") String productName) {
		System.out.println("---------------------ANTES-----------------");

		Product product = productRepository.findByName(productName);
		System.out.println(product);
		if (product == null)
			throw new ProductNotFoundException(productName);
		else {
			return product;
		}
	}
}
	

