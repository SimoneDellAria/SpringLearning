<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME PAGE</title>
</head>
<body>

	<h1>Home Page</h1>
	<hr>
	<p>Questa è la pagina principale!</p>
	
	<hr>
	<p>Benvenuto <security:authentication property="principal.username"/></p>
	<br>
	<p>Hai il ruolo di: <security:authentication property="principal.authorities"/></p>
	<hr>
	
	<security:authorize access="hasRole('PROFESSOR')">
	<p><a href="${pageContext.request.contextPath}/professors">Link per Professori</a></p>
	<hr>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<p><a href="${pageContext.request.contextPath}/systems">Link per Amministratori</a></p>
	<hr>
	</security:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>