package it.mycompany.springfreemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@GetMapping("/")
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Benvenuto nell'App!");
		return "welcome";
	}

}
