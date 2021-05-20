package it.mycompany.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.mycompany.spring.bean.Address;
import it.mycompany.spring.bean.Person;

@Configuration
public class AppConfiguration {

	@Bean(name = "person_bean")
	@Scope(value = "prototype")
	public Person getPerson() {
		return new Person();
	}

	@Bean(name = "address_bean_1")
	@Scope(value = "prototype")
	public Address getAddress1() {
		return new Address("Viale Europa");
	}
	
	@Bean(name = "address_bean_2")
	@Scope(value = "prototype")
	public Address getAddress2() {
		return new Address("Via delle Camelie");
	}

}
