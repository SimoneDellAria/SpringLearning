package it.mycompany.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressionUtility {
	
	@Pointcut("execution(public void it.mycompany.spring.dao.*.*(..))")
	public void pointcutForDAO() {}
	
	@Pointcut("execution(public void it.mycompany.spring.dao.*.sendMail())")
	public void pointcutForSendMail() {}
	
	@Pointcut("pointcutForDAO() && !pointcutForSendMail()")
	public void pointcutForDAONotSendMail() {}

}
