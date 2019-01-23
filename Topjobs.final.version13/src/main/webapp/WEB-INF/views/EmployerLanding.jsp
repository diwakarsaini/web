<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>YOU ARE AN EMPLOYER! </p>
<%=request.getRemoteUser() %>
<br>
<a href="Logout">LogOut</a>
<br>


<a href="NewJob">Create a new JOB?</a>

<a href="ShowJobServlet">Show list of jobs</a>

<form action="ShowResumeEmployerServlet">
	<input type="submit" value="Show Resume">
</form>

<a href="PurchaseLogin">Purchase Additional Login</a>

</body>
</html>