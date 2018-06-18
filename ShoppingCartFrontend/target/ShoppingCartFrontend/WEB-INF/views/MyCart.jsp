<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
</head>

<body>
	<div class="container">
		<table class="table table-striped table-bordered">
		<tr style="text-align:center">
			<td><h4>Image</h4></td>
			<td><h4>Name</h4></td>
			<td><h4>Price</h4></td>
			<td><h4>Quantity</h4></td>
			<td><h4>Action</h4></td>
		</tr>
		
		<c:forEach var="a" items="${cartList}">
			<tr style="text-align:center">
				<td><img alt="" src="resources/images/${a.productID}.png"></td>
				<td>${a.productName}</td>
				<td>${a.price}</td>
				<td>${a.quantity}    :
					<a href="increase/${a.id}"><button class="btn btn-primary btn-sm">+</button></a>
					<a href="decrease/${a.id}"><button class="btn btn-primary btn-sm">-</button></a></td>
				<td><a href="remove/${a.id}"><button type="button" class="btn btn-danger btn-sm">Delete</button></a><br></td>
			</tr>
		</c:forEach>
		</table>
		
		<c:if test="${emptyCart!= true}">
		<a href="empty"><button class="img-responsive pull-right btn-danger btn-lg"><span class="glyphicon glyphicon-trash"></span>Empty Cart</button></a>
		<a href="buy?buyreq=cart"><button class="img-responsive pull-right btn-primary btn-lg"><span class="glyphicon glyphicon-shopping-cart"></span>Buy</button></a>
		</c:if>
	</div>
	
	${buyingError}
	${noItems}
	
</body>
</html>