package it.mycompany.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.mycompany.spring.bean.Person;
import it.mycompany.spring.config.AppConfiguration;

public class App {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		Person person = (Person) applicationContext.getBean("person_bean");
		person.printAddress();

		((ConfigurableApplicationContext) applicationContext).close();
	}
}
