package it.mycompany.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/professors")
	public String showProfessorPage() {
		return "professors";
	}
	
	@GetMapping("/systems")
	public String showSystemPage() {
		return "systems";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		return "access-denied";
	}
}
