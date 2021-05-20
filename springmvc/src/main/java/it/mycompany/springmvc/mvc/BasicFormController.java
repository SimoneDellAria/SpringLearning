package it.mycompany.springmvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
public class BasicFormController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "basic-form";
	}

	@RequestMapping("/processForm")
	public String newProcessForm(@RequestParam("personName") String input_name, Model model) {

		input_name = input_name.toUpperCase();
		model.addAttribute("message", input_name);
		return "welcome";
	}
}
