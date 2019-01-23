<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>     
    
    
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
Enter Email:<input type="text" name="email" placeholder="Enter email here"> Note: your email is your username<br>
Enter password:<input type="password" name="pswd" placeholder="Enter password here"><br>
Join as:<input type="radio" name="role" value="Employer">Employer
	 <input type="radio" name="role" value="JobSeeker">JobSeeker
	 <input type="radio" name="role" value="Admin">Admin
	 <br>
	 <input type="submit" name="submit" value="Register">
</form>

<% if(request.getAttribute("exception")!=null){
	
	String str = (String) request.getAttribute("exception");
	out.print(str);
	} %>
		
<br>
Already have an Account?<a href="LoginServlet">Sign In</a>

</body>
</html>