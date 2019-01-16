<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.topjobs.domain.Job" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ page isELIgnored="false"%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Job> ls =(List)request.getAttribute("JobList"); %>
<h1>Welcome </h1>
<%= request.getRemoteUser() %>
<h1>Jobs for you</h1>
<h2><%=ls.size()%> Jobs</h2>
<table>

<c:set var="jobList" value="<%=ls%>" />
<c:forEach var="job" items="<%=ls %>">
				
				<tr>
					<td><c:out value="${job.jobDescription}"></c:out></td>
					<td><c:out value="${job.jobTitle}"></c:out></td>
					
				</tr>
</c:forEach>

</table>

<a href="LoginServlet">Home</a>

</body>
</html>