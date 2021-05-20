package it.mycompany.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(this.getClass() + " Interazione con DB Simulata");
	}

}
