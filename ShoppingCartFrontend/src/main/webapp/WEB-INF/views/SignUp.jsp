<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign up</title>
<link rel="stylesheet" href="resources/css-styles/signup.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
		<form action="from_form" method="post" class="form-container">
		<div class="form-group">
		
			<h1>Sign Up</h1>
			<a href="signin" style="float:right">Already a member? Log in</a>
			<p>Please fill in this form to create an account.</p><br>
			

			<label for="fullname"><b>Full Name</b></label> 
			<input style="color:black" class="form-control" type="text" placeholder="Enter Name" name="fullname" required> <br>
			
			<label for="email"><b>Email</b></label> 
			<input style="color:black" class="form-control" type="email" placeholder="Enter Email" name="email" required> <br>
			
			<label for="psw"><b>Password</b></label> 
			<input style="color:black" class="form-control" type="password" placeholder="Enter Password" name="psw" required> <br>
			
			<label for="psw-repeat"><b>Repeat Password</b></label> 
			<input style="color:black" class="form-control" type="password" placeholder="Repeat Password" name="psw-repeat" required> <br>
			
			<label for="mob"><b>Mobile number</b></label> 
			<input style="color:black" class="form-control" type="text" placeholder="Enter mobile no" name="mobile" required> <br>
			
				<button type="submit" class="block1 btn">Sign Up</button>
				<button type=reset class="block2 btn">Cancel</button><br><br>
			
			
			<p style="color: dodgerblue">
				By creating an account you agree to our <a href="#" style="color: dodgerblue">Terms & Privacy</a>.
			</p>
		</div>
	</form>
	</div>
		<div class="col-md-3"></div>
	</div>
</div>
</body>
</html>