<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign in</title>
<link rel="stylesheet" href="resources/css-styles/signin.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/global.css" type="text/css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.bg {background: url("resources/images/background4.jpg");}
</style>
</head>

<body>
	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6 col-sm-4 col-xs-12">
			
				<form class= "form-container" action="j_spring_security_check" method="post">
					<h2>Sign In</h2>
					<a href="signup">New to this site? Sign Up</a><br>
					
						<div class="imgcontainer">
							<img src="resources/images/avatar1.png" alt="Avatar" class="avatar">
						</div>
				
						<div class="form-group">
							<label for="exampleInputEmail1"><b>Username / Email id</b></label> 
							<input style="color:black" class="form-control" id="exampleInputEmail1" type="text" placeholder="Enter Email" name="j_username" required><br>
				
							<label for="exampleInputPassword1"><b>Password</b></label> 
							<input style="color:black" class="form-control" id="exampleInputPassword1" type="password" placeholder="Enter Password" name="j_password" required><br><br>
						
							<div class="clearfix">
								<button type="submit" class="block1 btn">Sign In</button><br>
								<button type="reset" class="block2 btn">Cancel</button>		
							</div>	
						
						</div>
						 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>
