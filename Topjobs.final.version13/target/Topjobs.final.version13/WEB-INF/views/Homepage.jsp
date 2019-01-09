<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>TopJobs</h1>
<h2>Welcome to TopJobs</h2>
<br>
<br>
<h3>Register Form</h3>

<form action="RegisterServlet" method="post">
Enter First name:<input type="text" name="fName" placeholder="Enter first name here"><br>
Enter Last name:<input type="text" name="lName" placeholder="Enter last name here"><br>
Enter Email:<input type="text" name="email" placeholder="Enter email here"><br>
Enter password:<input type="password" name="pswd" placeholder="Enter password here"><br>
Join as:<input type="radio" name="role" value="Employeer">Employeer
	 <input type="radio" name="role" value="Job Seeker">Job Seeker
	 <input type="radio" name="role" value="Admin">Admin
	 <br>
	 <input type="submit" name="submit" value="Register">
</form>


<h3>Login Form</h3>
<form action="loginform">
Enter Email:<input type="text" name="email" placeholder="Enter email here"><br>
Enter password:<input type="password" name="pswd" placeholder="Enter password here"><br>

	<input type="submit" value="Login">
</form>
</body>
</html>