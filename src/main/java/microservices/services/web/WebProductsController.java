package microservices.services.web;

import microservices.services.web.Product;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Client controller, fetches Products info from the microservice via
 * {@link WebProductsService}.
 * 
 * @author Blanca AT
 */

@Controller
public class WebProductsController {

	@Autowired
	protected WebProductsService productsService;

	protected Logger logger = Logger.getLogger(WebProductsController.class
			.getName());

	public WebProductsController(WebProductsService productsService) {
		this.productsService = productsService;
	}


	
	@RequestMapping("/products/{productName}")
	public String byName(Model model, @PathVariable("productName") String productName) {
		Product product = productsService.findByName(productName);
		model.addAttribute("product", product);		
		return "product-details";
	}
	
	@RequestMapping("/collections/{collectionName}")
	public String showCollection(@PathVariable("collectionName") String collectionName) {
		if (collectionName.equals("bicolour")) {
			return "bicolour";
		}
		else if (collectionName.equals("lines")) {
			return "lines";
		}
		else if (collectionName.equals("universe")) {
			return "universe";
		}
		else {
			return "error";
		}
	}
}
