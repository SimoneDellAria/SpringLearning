package it.mycompany.springfreemarker.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.mycompany.springfreemarker.dao.ProductDAO;
import it.mycompany.springfreemarker.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDAO productDAOInstance;

	@PostMapping("/add")
	public String add(@ModelAttribute("data") Product product) {
		this.productDAOInstance.add(product);
		return "redirect:/product/list";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("data") Product product) {
		this.productDAOInstance.update(product);
		return "redirect:/product/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int productId) {
		this.productDAOInstance.delete(productId);
		return "redirect:/product/list";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		ArrayList<Product> products = (ArrayList<Product>) this.productDAOInstance.getAll();
		model.addAttribute("availableProducts", products);
		return "show-products";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd() {
		return "product-form";
	}

	/*
	 * @GetMapping("/showFormForUpdate/{productId}") public String
	 * showFormForUpdate(@PathVariable int productId, Model model) {
	 * 
	 * Product product = this.productDAOInstance.getProductById(productId);
	 * model.addAttribute("product", product); return "product-form"; }
	 */

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int productId, Model model) {

		Product product = this.productDAOInstance.getProductById(productId);
		model.addAttribute("product", product);
		return "product-form";
	}

	/*
	 * @GetMapping("/list/{productId}") public String getProductById(@PathVariable
	 * int productId) { Product product =
	 * this.productDAOInstance.getProductById(productId); return
	 * "redirect:/product/list"; }
	 */
}
