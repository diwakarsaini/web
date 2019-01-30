<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.niit.domain.*"%>
<%@ page import="com.niit.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<% List<Job> jobList = (List<Job>) request.getAttribute("listJobs"); %>

<c:set var="jobs" value="<%=jobList %>"/>
<table style="border:1px solid;">
<form action="/topjobs/admin/DeleteJobServlet">
<c:forEach var="job" items="${jobs}">
<tr>
<td><c:out value="${job.jobId}"></c:out></td>
<td><c:out value="${job.jobTitle}"></c:out></td>
<td><c:out value="${job.postedDate}"></c:out></td>
<td><c:out value="${job.elapsedDays}"></c:out></td>
<td><c:out value="${job.jobCategory}"></c:out></td>
<td><input type="checkbox" name="jobIds" value="${job.jobId}"></td>
</tr>

</c:forEach>
<input type="submit" value="Delete these jobs">


</form>
</table>

<a href="/topjobs/LoginServlet">Homepage</a>

</body>
</html>