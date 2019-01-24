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
<h1>Registration Successful !</h1>
<%if(request.getAttribute("exception")!=null){
	String exception = (String)request.getAttribute("exception");
}
	%>

<c:if test="${exception!=null }"> <c:out value="${exception}"/></c:if>
<a href="LoginServlet">Click here to Login</a>
<a href="Homepage">Homepage</a> 
</body>
</html>