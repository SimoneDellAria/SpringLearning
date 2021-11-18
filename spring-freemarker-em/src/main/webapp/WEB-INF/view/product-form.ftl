<!DOCTYPE html>
<html>
<head></head>

<body>

	<#if product??>
	
	<h2>UPDATE PRODUCT INFO</h2>
	<div>
	<form action="update" id="data" method="POST">
	<input type="hidden" name="id" id="id" value="${product.id}" />
		<table>
			<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><input type="text" name="name" id="name" value="${product.name}" /></td>
				</tr>
				<tr>
					<td><label>Price:</label></td>
					<td><input type="text" name="price" id="price" value="${product.price}" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Update" name="update" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	
	<#else>
	<h2>ADD PRODUCT</h2>
	<div>
	<form action="add" id="data" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><input type="text" name="name" id="name" value="" /></td>
				</tr>
				<tr>
					<td><label>Price:</label></td>
					<td><input type="text" name="price" id="price" value="" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Create" name="send" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	
	</#if>
	
</body>
</html>