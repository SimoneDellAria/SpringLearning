package it.mycompany.spring.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	@AfterReturning(
			pointcut="execution(* it.mycompany.spring.dao.AccountDAO.findAccounts(..))", 
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinpoint, List<Account> result) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println("Metodo AfterReturning invocato dopo la corretta uscita da " + methodName);
		setNameToUpperCase(result);
		System.out.println("Contenuto della risposta: " + result);
	}
	
	private void setNameToUpperCase(List<Account> accounts) {
		for (Account account: accounts) {
			account.setName(account.getName().toUpperCase());
		}
	}
}
