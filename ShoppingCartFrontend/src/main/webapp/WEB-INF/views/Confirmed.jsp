<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirmed</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<center>
		<h1>Welcome to Shopping Kart</h1>
		${success} 
	</center>
	<br>
	<jsp:include page="login_header.jsp"></jsp:include>
	<jsp:include page="bootstrap_product_menu.jsp"></jsp:include>
	<hr color="blue" size="4">

	<center>
		<p>Your payment is confirmed! Thank you for shopping with us. </p>
		<a href="home"><button class="btn btn-warning">Continue shopping</button></a>
	</center>
</body>
</html>