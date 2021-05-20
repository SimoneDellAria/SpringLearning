package it.mycompany.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

	private String person_name;

	@Autowired
	@Qualifier(value = "address_bean_2")
	private Address address;
	
	public Person() {
		
	}

	public Person(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void printAddress() {
		System.out.println("Indirizzo: " + address.getAddress_name());
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

}
