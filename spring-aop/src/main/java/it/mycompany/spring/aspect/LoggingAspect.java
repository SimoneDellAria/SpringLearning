package it.mycompany.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.mycompany.spring.pojo.Account;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
	
	@Before("it.mycompany.spring.aspect.PointcutExpressionUtility.pointcutForDAONotSendMail()")
	public void showSomething(JoinPoint joinpoint) {
		System.out.println("Stampa qualcosa prima dell'esecuzione dei metodi nel DAO");
		MethodSignature methodSig = (MethodSignature) joinpoint.getSignature();
		System.out.println("Firma del metodo: " + methodSig );
		
		Object[] parameters = joinpoint.getArgs();
		for (Object obj : parameters) {
			if (obj instanceof Account) {
				Account account = (Account) obj;
				System.out.println(account.toString());
			}
		}
	}
}
