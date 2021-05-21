package it.mycompany.spring.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Account> findAccounts(){
		System.out.println("All'interno del metodo findAccounts");
		List<Account> accounts = new ArrayList<Account>();
		Account account1 = new Account(1, "Donald", "Duck");
		Account account2 = new Account(2, "Jonh", "Doe");
		Account account3 = new Account(3, "Mario", "Rossi");
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}
	
	
}
