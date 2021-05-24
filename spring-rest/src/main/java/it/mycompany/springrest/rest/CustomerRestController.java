package it.mycompany.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mycompany.springrest.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private List<Customer> customers;

	@PostConstruct
	private void createCustomerList() {
		customers = new ArrayList<>();
		customers.add(new Customer(0, "Mario", "Rossi"));
		customers.add(new Customer(1, "Donald", "Duck"));
		customers.add(new Customer(2, "Bugs", "Bunny"));
	}

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customers;
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		return customers.get(customerId);
	}
}