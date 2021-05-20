package it.mycompany.springmvc.dao;

import java.util.List;

import it.mycompany.springmvc.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
