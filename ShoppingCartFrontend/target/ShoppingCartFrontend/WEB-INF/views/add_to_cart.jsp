<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products selected by me</title>
</head>

<body>
<%-- 	<c:if test="${didUserSearchProducts}"> --%>
<!-- 	<div class="container"> -->
<!-- 		<form action="cart/add/" method="get"> -->
<%-- 		<c:forEach var="p" items="${categories}"> --%>
<%-- 			<img src="${selectedProductImage}"><br><br> --%>
<!-- 			<p> -->
<%-- 				${p.name}<br> --%>
<%-- 				${p.price} --%>
<!-- 			</p> -->
<%-- 				<a href="cart/add/${p.product_id}">Add To Cart</a> --%>
<%-- 		</c:forEach> --%>
<!-- 		</form> -->
<!-- 	</div> -->
<%-- 	</c:if> --%>
	
	<c:if test="${isUserSelectedProduct}">
		<div class="container">
			<div class="row">
				<div class="col-md-3 img-thumbnail">
					<img src="${selectedProductImage}"><br><br>
					<p>
						${selectedProduct.name}<br>
						Rs. ${selectedProduct.price}
						
					</p>
			
					<c:if test="${pageContext.request.userPrincipal.name==null}">
						Please <a href="signin">login here</a> to Add To Cart <br><br>
					</c:if>
					
					<c:if test="${pageContext.request.userPrincipal.name!=null}">
						<a href="cart/add/${selectedProduct.product_id}"><button class="btn btn-warning">Add To Cart</button></a>
					</c:if>
					<a href="buy?buyreq=prpage&prid=${selectedProduct.product_id}"><button class="btn btn-primary">Buy</button></a>
					
				</div>
			</div>
		</div>
	</c:if>
	
</body>
</html>