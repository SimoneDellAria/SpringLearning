package it.mycompany.spring.bean;

public class Address {

	private String address_name;

	public Address() {

	}
	
	public Address(String address_name) {
		this.address_name = address_name;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

}
