<#include "common.ftl">
<!DOCTYPE html>
<html>
<head></head>

<#assign myMessage="Hi from your internal variable! Product Info">
<#assign welcome="Mmm...${customMessage}">
<body>
	<h1>${welcome + " " + myMessage}</h1>
	<li>Product Selected: ${product.name}</li>
	<li>
		Product Price: ${product.price}
		<#if product.price gt 200 >
		 (NOT SO CHEAP...)
		<#elseif product.price lt 200 && subscribedMemeber == true>
		 (THAT'S CHEAP!) EXTRA DISCOUNT JUST FOR YOU!
		</#if>
	</li>
	<li>Product ID: ${product.id}</li>
	
	<h2>AVAILBLE PRODUCTS</h2>
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
			</tr>
			</#list>
		</tbody>
	</table>
	<p>${commonProperty}</p>
</body>
</html>