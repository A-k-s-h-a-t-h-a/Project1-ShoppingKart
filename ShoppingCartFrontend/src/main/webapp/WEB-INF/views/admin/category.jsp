<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Category </title>
<link rel="stylesheet" href="resources/css-styles/adminlinks.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
	
<body>
	<div class="container">
		 <form action="category/save/" method="post" >
			<table class="table table-bordered">
	 			<c:if test="${!empty category.category_id}">
					<input type="hidden" name='category_id' value="${category.category_id}" />
				</c:if>
				<c:if test="${empty category.category_id}">
					<tr>
						<td>ID</td>
						<td><input type="text" name='category_id' required/></td>
					</tr>
				</c:if>
	
				<tr>
					<td>Name</td>
					<td><input type="text" name='name' value="${category.name}" /></td>
				</tr>
	
				<tr>
					<td>Description</td>
					<td><input type="text" name='description' value="${category.description}" /></td>
				</tr>
			</table>
			<input type="submit" class="btn btn-default" value='Submit Category'>
			<button type="reset" class="btn btn-default">Cancel</button><br><br><br><br>
		</form> 
	</div>
	
	${categorysuccess}
	${categoryerror}
	
	<div class="container">
		<table class="table table-striped table-bordered table-hover">
				<tr style="text-align:center">
					<td><h4>Category ID</h4></td>
					<td><h4>Category Name</h4></td>
					<td><h4>Category Description</h4></td>
					<td><h4>Action</h4></td>
				</tr>
				<c:forEach var="category" items="${categoryList}"> <!-- list of categories from database attached to httpsession in homecontroller-->
					<tr style="text-align:center">
						<td>${category.category_id} </td>
						<td>${category.name} </td>
						<td>${category.description} </td>
						<td>
							
								<a href="category/delete/?id=${category.category_id}"><button type="button" class="btn btn-danger">Delete</button></a> | 
								<a href="category/edit/?id=${category.category_id}"><button type="button" class="btn btn-info">Edit</button></a>
							
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
		
</body>
</html>