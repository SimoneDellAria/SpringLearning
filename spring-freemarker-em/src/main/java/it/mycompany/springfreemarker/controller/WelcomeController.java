package it.mycompany.springfreemarker.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.mycompany.springfreemarker.model.Product;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@GetMapping("/")
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Benvenuto nell'App!");
		return "welcome";
	}
	
	@GetMapping("/showProduct")
	public String showProduct(ModelMap model) {
		Product product = new Product(129349L, "HP ENVY-1600", 150);
		model.addAttribute("product", product);
		model.addAttribute("customMessage", "I'm glad to see you!");
		model.addAttribute("subscribedMemeber", true);
		ArrayList<Product> availableProducts = new ArrayList<>();
		availableProducts.add(new Product(1L, "HP ENVY-1700", 500));
		availableProducts.add(new Product(2L, "HP ENVY-1500", 1200));
		availableProducts.add(new Product(3L, "HP ENVY-1400", 700));
		availableProducts.add(new Product(4L, "HP ENVY-1300", 299));
		model.addAttribute("availableProducts", availableProducts);
		return "product-info";
	}

}
