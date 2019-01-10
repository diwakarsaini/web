<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="j_security_check">

		Login as: <br>
				<input type="radio" name="role" value="JobSeeker" checked="checked" />JobSeeker 
				<input type="radio" name="role"value="Employer" />Employer 
				<input type="radio" name="role" value="Admin" />Admin 
				<br>
				<label for="userid"><b>User ID</b></label> 
				<input type="text" placeholder="Enter User ID " name="j_username" required /> 
				<br>
				<label for="pass"><b>Password</b></label>
				<input type="password" name="j_password" placeholder="Enter Password" required /> 
				<br>
				<input type="submit" value="LOGIN" /> 
				<br>
				New User?<a href="register">Register</a>



	</form>
	
	
</body>
</html>