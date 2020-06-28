package microservices.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller.
 * 
 * @author Blanca AT
 */

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
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

}
