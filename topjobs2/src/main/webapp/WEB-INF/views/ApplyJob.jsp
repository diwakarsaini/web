<%@ page 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="com.niit.domain.Job" %>
    <%@ page import="com.niit.service.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobs by You</title>
<link rel="stylesheet" type="text/css" href="C:\Users\Shivang\eclipse-workspace\topjobs\topjobs\src\main\webapp\WEB-INF\CSS\TopjobsStyle.css" />

</head>
<body style="background-color: lightsalmon">
<header class="headerhome"></header>

<div class=""row p-3 mb-2 bg-secondary text-primary">

<% 
   JobService js=new JobService();
   List<Job> ls =js.getAllJobs();
    
%>

<h1>Apply from these jobs</h1>
<h2><%=ls.size()%> Jobs</h2>

<form action="/topjobs/job/ApplyJobServlet" id="jobApply">

<table>
<div class="form-group">


<c:set var="jobList" value="<%=ls%>" /> 
<c:forEach var="job" items="${jobList}">
				
				<tr>
					
					<td>Job Title: <c:out value="${job.jobTitle}"></c:out></td>
					<td>  Company Name: <c:out value="${job.jobName}"></c:out></td>
					<td>${job.jobId}<input type="checkbox" name="jobs" value="${job.jobId}"></td>
					
					<td><form action="ShowThisJobServlet" target="_blank">
					<input type="hidden" name="thisJob" value="${job.jobId}">			
					<input type="submit" value="SHOW">
					
					
					 </form>
					
					
					<%-- <td>${job.jobId}<input type=button onClick=window.open("/topjobs/src/main/webapp/index.jsp","Ratting","width=550,
height=170,left=150,top=200,toolbar=0,status=0,"); value="Open Window"></td> --%>
				</tr>
</c:forEach>

</table>
<button type="submit" class="btn btn-primary" value="SUBMIT">APPLY JOBS</button>


</form>
</div>


<p><a href="logout">Logout</a></p>



</div>

</body>
</html>