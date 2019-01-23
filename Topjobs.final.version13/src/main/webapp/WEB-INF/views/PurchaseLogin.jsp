<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Purchase additional Logins</h1>
<h6>Note: Get Discount of <%=getServletContext().getInitParameter("discount") %> on service fee if you purchase 5 or more Logins</h6>

<form action="PurchaseLoginServlet" method="post">
No of Logins: <input type="number" name="number" required>
<input type="submit" value="Purchase">
</form>
<br>
<a href=\"EmployerLanding\">Home</a> 



</body>
</html>