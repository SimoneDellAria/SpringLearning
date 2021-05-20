<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Salva Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css}" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css}" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<h3>Salva Nuovo Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nome:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Cognome:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Salva" class="save" /></td>
					</tr>
				</tbody>
			</table>

		</form:form>
		
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Torna alla lista</a>
		</p>

	</div>

</body>
</html>