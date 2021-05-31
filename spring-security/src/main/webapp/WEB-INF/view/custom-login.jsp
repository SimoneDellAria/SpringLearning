<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Pagina Di Login</title>

<link rel="stylesheet" type="text/css" href="css/login-style.css">
</head>

<body>
	<div class="form-title">
		<h3>Pagina di Login</h3>
	</div>

	<div class="form-content">
		<form:form
			action="${pageContext.request.contextPath}/authenticateUser"
			method="POST">

			<c:if test="${param.error!=null}">
				<i class="bad_credential">Mi dispiace, credenziali errate!</i>
			</c:if>

			<c:if test="${param.logout!=null}">
				<i class="logout_ok">Logout effettuato con successo</i>
			</c:if>

			<p>
				Nome Utente: <input type="text" name="username" />
			</p>
			<p>
				Password: <input type="password" name="password" />
			</p>
			<input type="submit" value="Login" />
		</form:form>
	</div>
</body>
</html>