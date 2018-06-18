<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier</title>
<link rel="stylesheet" href="resources/css-styles/adminlinks.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<form action="supplier/save/" method="post">
			<table class="table table-bordered">
				<c:if test="${!empty supplier.supplier_id}">
					<input type="hidden" name='supplier_id' value="${supplier.supplier_id}" />
				</c:if>
				<c:if test="${empty supplier.supplier_id}">
					<tr>
						<td>ID</td>
						<td><input type="text" name='supplier_id' required/></td>
					</tr>
				</c:if>
	
				<tr>
					<td>Name</td>
					<td><input type="text" name='name' value="${supplier.name}" required></td>
				</tr>
	
				<tr>
					<td>Address</td>
					<td><input type="text" name='address' value="${supplier.address}" required></td>
				</tr>
			</table>
			<input type="submit" class="btn btn-default" value='Submit Supplier'>
			<button type="reset" class="btn btn-default">Cancel</button><br><br>
		</form> 	
	</div>
	
	${suppliersuccess}
	${suppliererror}
	
	<div class="container">
		<table class="table table-striped table-bordered table-hover">
				<tr style="text-align:center">
					<td><h4>Supplier ID</h4></td>
					<td><h4>Supplier Name</h4></td>
					<td><h4>Supplier Address</h4></td>
					<td><h4>Action</h4></td>
				</tr>
				<c:forEach var="supplier" items="${supplierList}">
					<tr style="text-align:center">
						<td>${supplier.supplier_id} </td>
						<td>${supplier.name} </td>
						<td>${supplier.address} </td>
						<td>
							
								<a href="supplier/delete/?id=${supplier.supplier_id}"><button type="button" class="btn btn-danger">Delete</button></a> | 
								<a href="supplier/edit/?id=${supplier.supplier_id}"><button type="button" class="btn btn-info">Edit</button></a>
							
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	
</body>
</html>