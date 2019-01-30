<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<%@ page import="com.niit.domain.PurchaseEvents" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

<% List<PurchaseEvents> pList = (List<PurchaseEvents>) request.getAttribute("purchaseList"); %>

<c:set var="purchases" value="<%=pList %>"/>
<form action="/topjobs/admin/FinalizePurchaseServlet" method="post">
<table>
<c:forEach var="purchase" items="${purchases}">
<tr>
<td>Employer: <c:out value="${purchase.employer.user_name}"></c:out></td>
<td>Logins: <c:out value="${purchase.logins}"></c:out></td>

<td><input type="radio" name="eventId" value="${purchase.eventId}"></td>
</tr>

</c:forEach>

</table>

<input type="submit" name="finalize" value="Delete">
<input type="submit" name="finalize" value="Approve">
</form>

<a href="/topjobs/LoginServlet">Home</a>


</body>
</html>