package it.mycompany.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.mycompany.spring.dao.AccountDAO;
import it.mycompany.spring.pojo.Account;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountDAO accountDAOInstance = context.getBean("accountDAO", AccountDAO.class);
		// @Before Advice Demonstration
		/*
		Account account = new Account(1, "Simone", "Dell'Aria");
		accountDAOInstance.addAccount(account);
		accountDAOInstance.removeAccount();
		accountDAOInstance.sendMail();
		*/
		
		// @AfterReturning Advice Demonstration
		/*
		List<Account> accounts = accountDAOInstance.findAccounts(false);
		System.out.println("Contenuto della risposta dal main: " + accounts);
		*/
		
		// @AfterThrowing Advice Demonstration
		List<Account> accounts2 = null;
		try {
			accounts2 = accountDAOInstance.findAccounts(true);
		} catch (Exception ex) {
			System.out.println("Main Method: Eccezione " + ex);
		}
		System.out.println("Contenuto della risposta dal main: " + accounts2);
		context.close();
	}

}
