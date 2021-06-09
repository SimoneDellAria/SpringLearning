package it.mycompany.springresthib.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mycompany.springresthib.entity.Customer;
import it.mycompany.springresthib.exception.CustomerNotFoundException;
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
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = this.customerServiceInstance.getCustomer(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Il Customer con id: " + customerId + " non è presente");
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		this.customerServiceInstance.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		this.customerServiceInstance.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer customer = this.customerServiceInstance.getCustomer(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Il Customer con id: " + customerId + " non è presente");
		}
		this.customerServiceInstance.deleteCustomer(customerId);
		return "Eliminato Customer con Id: " + customerId;
	}
	
}
