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
</head>
<body>

<% List<Job> jobList = (List<Job>) request.getAttribute("listJobs"); %>
<h1>Select a job to change it's category.</h1>
<c:set var="jobs" value="<%=jobList %>"/>
<table style="border:1px solid;">
<form action="/topjobs/admin/ManageCategoryServlet">
<c:forEach var="job" items="${jobs}">
<tr>
<td><c:out value="${job.jobId}"></c:out></td>
<td><c:out value="${job.jobTitle}"></c:out></td>
<td><c:out value="${job.jobName}"></c:out></td>
<td><c:out value="${job.jobCategory}"></c:out></td>
<td><c:out value="${job.jobId}"></c:out></td>
<td><input type="radio" name="jobId" value="${job.jobId}"></td>

</tr>
</c:forEach>
<td><select name=category><option>Administrative</option><option>IT</option><option>Finance</option></select></td>


<input type="submit" value="Change Category">


</form>
</table>

<a href="/topjobs/LoginServlet">Homepage</a>



</body>
</html>