package it.mycompany.springmvc.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private Logger LOG = Logger.getLogger(LoggingAspect.class);

	@Pointcut("execution(* it.mycompany.springmvc.controller.*.*(..))")
	private void logForController() {}
	
	@Pointcut("execution(* it.mycompany.springmvc.dao.*.*(..))")
	private void logForDAO() {}
	
	@Pointcut("execution(* it.mycompany.springmvc.service.*.*(..))")
	private void logForService() {}
	
	@Pointcut("logForController() || logForDAO() || logForService()")
	private void logForApp() {}
	
	@Before("logForApp()")
	public void beforeLogs(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().toShortString();
		LOG.info("@Before: Metodo -> " + method);
		
		Object[] args = joinpoint.getArgs();
		for (Object obj: args) {
			LOG.info("argument: " + obj);
		}
	}
	
	@AfterReturning(pointcut="logForApp()", returning="result")
	public void afterReturningLogs(JoinPoint joinpoint, Object result) {
		String method = joinpoint.getSignature().toShortString();
		LOG.info("@AfterReturning: Metodo -> " + method);
		LOG.info("Oggetto restituito: " + result);
	}
	
	
}
