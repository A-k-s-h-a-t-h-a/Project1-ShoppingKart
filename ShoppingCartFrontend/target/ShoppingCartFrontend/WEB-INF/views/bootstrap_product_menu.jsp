<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Product menu</title>
</head>

<body>
	<div class="row">	
		<div class="col-md-1 col-sm-4 col-xs-12">
			<div class="container">
				<c:forEach var="category" items="${categoryList}">
					<div class="dropdown col-xs-2">
					    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">${category.name}
							<span class="caret"></span>
						</button>
							
						<ul class="dropdown-menu">
							<c:forEach var="product" items="${category.products}">
								<li><a href="product/get/${product.product_id}">${product.name}</a></li>
							</c:forEach>  
			   			</ul>
			   		</div>
		  		</c:forEach>
			</div>
		</div>
		<div class="col-md-11"></div>
	</div>
</div>
</body>
</html>