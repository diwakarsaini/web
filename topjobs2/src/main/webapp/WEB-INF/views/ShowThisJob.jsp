<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.niit.domain.Job" %> 
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This Job</title>
</head>
<body>
<p>Welcome See this job</p>

<%
Job jobDesc=(Job)request.getAttribute("thisJob"); 

%>
<table>

<c:set var="job" value="<%=jobDesc%>" />
<tr><td>Job Id: <c:out value="${job.jobId}"></c:out></td></tr>

<tr><td>Company Name: <c:out value="${job.jobName}"></c:out></td></tr>
<tr><td>Job Title: <c:out value="${job.jobTitle}"></c:out></td></tr>
<tr><td>Job Description: <c:out value="${job.jobDescription}"></c:out></td></tr>

</table>
</body>
</html>