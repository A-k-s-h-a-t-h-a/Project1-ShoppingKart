<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Navigation Bar</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body style="padding-top:75px">

	<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container-fluid">
	  
	    <div class="navbar-header" style="padding-top:15px">
	      <a class="navbar-brand" href="home">Shopping Kart</a>
	    </div>
	   
    	<ul class="nav navbar-nav navbar-left">
	      <c:if test="${ifLoggedIn!=true}">
		      <c:if test="${pageContext.request.userPrincipal.name == null}">
		      	<li><a href="signin"><button class="btn btn-success navbar-btn"><span class="glyphicon glyphicon-log-in"></span> Log in</button></a></li>
		     	<li><a href="signup"><button class="btn btn-warning navbar-btn"><span class="glyphicon glyphicon-user"></span> Sign Up</button></a></li>
		      </c:if> 
	      </c:if>
	    </ul>
 
	    <ul class="nav navbar-nav navbar-right">
	     <c:if test="${ifLoggedIn==true}">
		     <c:if test= "${isAdmin!=true}">
		     	<li><a href="mycart"><button class="btn btn-primary navbar-btn"><span class="glyphicon glyphicon-shopping-cart"></span> My Cart(${size})</button></a></li>
		     </c:if>
		     <c:if test="${pageContext.request.userPrincipal.name!=null}">
		     	<li><a href="j_spring_security_logout"><button class="btn btn-danger navbar-btn"><span class="glyphicon glyphicon-log-out"></span> Log out</button></a></li>
		     </c:if>
	    </c:if>
	    <c:if test="${home==true}">
			 <li><a href="home"><button class="btn btn-info navbar-btn"><span class="glyphicon glyphicon-home"></span> Home</button></a></li>
		</c:if>
	    </ul>
		   
	  </div>
	</nav>

</body>
</html>