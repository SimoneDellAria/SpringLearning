<!DOCTYPE html>
<html>
<head></head>

<body>
	
	<h2>AVAILABLE PRODUCTS</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PRICE</th>
			</tr>
		</thead>
		<tbody>
			<#list availableProducts as currentProduct>
			<tr>
				<td>${currentProduct.id}</td>
				<td>${currentProduct.name}</td>
				<td>${currentProduct.price}</td>
				<td>
					<a href="delete?id=${currentProduct.id}">Delete</a>
					<a href="showFormForUpdate?id=${currentProduct.id}">Update</a>
				</td>
			</tr>
			</#list>
		</tbody>
	</table>
	<div>
	<input type="button" value="Add Product" onclick="window.location.href='showFormForAdd'; return false;" />
	</div>
</body>
</html>