package it.mycompany.spring.dao;

import org.springframework.stereotype.Component;

import it.mycompany.spring.pojo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account) {
		System.out.println(this.getClass() + " Interazione con DB Simulata");
	}
	
	public void removeAccount() {
		System.out.println(this.getClass() + " Interazione con DB Simulata");
	}
	
	public void sendMail() {
		System.out.println(this.getClass() + " Invio della mail in corso...");
	}
	
	
}
