<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<title>Lista Clienti</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
			<input type="button" value="Aggiungi Cliente" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
			<table>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Email</th>
					<th>Azione</th>
				</tr>
				<c:forEach var="currentCustomer" items="${customers}">
				
					<c:url var="updateLink" value="showFormForUpdate">
						<c:param name="customerId" value="${currentCustomer.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="delete">
						<c:param name="customerId" value="${currentCustomer.id}"/>
					</c:url>
					
					<tr>
						<td>${currentCustomer.firstName}</td>
						<td>${currentCustomer.lastName}</td>
						<td>${currentCustomer.email}</td>
						<td>
							<a href="${updateLink}">Aggiorna</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Vuoi Eliminare Questo Customer?'))) return false">Elimina</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>