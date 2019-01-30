<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.niit.domain.JobSeekerEvents" %>   
<%@ page import="java.util.List" %> 
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
<% List<JobSeekerEvents> eventList = (List<JobSeekerEvents>) request.getAttribute("eventList"); %>

<c:set var="eventList" value="<%=eventList%>"/>
<c:forEach var="event" items="${eventList}">
			<tr>
				<td><c:out value="${event.job.jobId}"></c:out></td>
				<td><a href="/topjobs/job/ShowThisJobServlet?thisJob=${event.job.jobId}">Show this Job</a>	</td>
			</tr>
</c:forEach>

</body>
</html>