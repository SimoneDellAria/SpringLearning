package it.mycompany.springresthib.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mycompany.springresthib.entity.Customer;
import it.mycompany.springresthib.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerServiceInstance;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return this.customerServiceInstance.getCustomers();
	}
}
