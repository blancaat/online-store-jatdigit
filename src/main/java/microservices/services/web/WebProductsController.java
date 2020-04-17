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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("accountNumber", "searchText");
	}

	@RequestMapping("/home")
	public String showHome() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout() {
		return "about";
	}
	
	@RequestMapping("/info")
	public String showInfo() {
		return "info";
	}

	@RequestMapping("/products/{productName}")
	public String byName(Model model, @PathVariable("productName") String productName) {
		Product product = productsService.findByName(productName);
		model.addAttribute("product", product);		
		return "product";
	}
	
	@RequestMapping("/product")
	public String byName() {
		//Product product = productsService.findByName("hola");
		return "product";
	}
}
