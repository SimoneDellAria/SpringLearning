package it.mycompany.springresthib.service;

import java.util.List;

import it.mycompany.springresthib.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
