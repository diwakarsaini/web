<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*"%>
<%@ page import="com.topjobs.request.ResumeRequest" %>
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
<%ResumeRequest rs = (ResumeRequest)request.getAttribute("resume");%>
<c:set var="resume" value="<%=rs %>"></c:set>

<table>
	<tr> <td>Name:<c:out value="${resume.name}"></c:out></td> </tr>
	<tr> <td>Email:<c:out value="${resume.email}"></c:out></td> </tr>
	<tr> <td>Contact:<c:out value="${resume.contactNumber}"></c:out></td> </tr>
	<tr> <td>Address<c:out value="${resume.address}"></c:out></td> </tr>
	<tr> <td>Skills: <c:forEach var="skill" items="${resume.skills}"> <c:out value="${skill}"></c:out>,</c:forEach></td> </tr>
	<tr> <td>Marks<c:out value="${resume.jobSeekerMarks}"></c:out></td> </tr>
	

</table>

</body>
</html>