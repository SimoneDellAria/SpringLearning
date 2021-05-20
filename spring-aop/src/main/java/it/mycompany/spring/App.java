package it.mycompany.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.mycompany.spring.dao.AccountDAO;
import it.mycompany.spring.pojo.Account;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountDAO accountDAOInstance = context.getBean("accountDAO", AccountDAO.class);
		Account account = new Account(1, "Simone", "Dell'Aria");
		accountDAOInstance.addAccount(account);
		accountDAOInstance.removeAccount();
		accountDAOInstance.sendMail();
		context.close();
	}

}
