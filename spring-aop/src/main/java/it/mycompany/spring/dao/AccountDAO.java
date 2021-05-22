package it.mycompany.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	
	public List<Account> findAccounts(boolean makeException){
		System.out.println("All'interno del metodo findAccounts");
		if(makeException) {
			throw new RuntimeException("Eccezione lanciata dal metodo findAccounts di proposito");
		}
		List<Account> accounts = new ArrayList<Account>();
		Account account1 = new Account(1, "Donald", "Duck");
		Account account2 = new Account(2, "Jonh", "Doe");
		Account account3 = new Account(3, "Mario", "Rossi");
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}
	
	/*
	public String goToSleep() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Buongiorno!";
	}
	*/
	
	public String goToSleep(boolean makeException) {
		if(makeException) {
			throw new RuntimeException("Eccezione lanciata dal metodo goToSleep di proposito");
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Buongiorno!";
	}
	
	
}
