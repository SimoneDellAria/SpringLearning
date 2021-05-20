package it.mycompany.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MailAspect {

	@Before("it.mycompany.spring.aspect.PointcutExpressionUtility.pointcutForSendMail()")
	public void beforeSendMail() {
		System.out.println("Metodo invocato prima dell'esecuzione del sendMail");
	}
}
