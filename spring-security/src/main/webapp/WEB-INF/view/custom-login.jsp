<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Pagina Di Login</title>

	<style type="text/css">
		.bad_credential {
			color: red;
		}
	</style>
</head>

<body>
	<h3>Pagina di Login</h3>
	<form:form action="${pageContext.request.contextPath}/authenticateUser"
		method="POST">

		<c:if test="${param.error!=null}">
			<i class="bad_credential">Mi dispiace, credenziali errate!</i>
		</c:if>

		<p>
			Nome Utente: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>