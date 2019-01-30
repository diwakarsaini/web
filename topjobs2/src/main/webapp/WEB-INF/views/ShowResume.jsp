<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
 <%@ page import="com.niit.ro.ResumeRequest" %> 
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resume Show here</title>
</head>
<body>
<%
ResumeRequest resume=(ResumeRequest)request.getAttribute("resume");  //resume is the name of attribute i used in servlet to get


%>

<h1>Resume</h1>
<table>
<c:set var="res" value="<%=resume%>" />
	<tr> 
	<td>Resume Id: <c:out value="${res.resumeId}"/></td></tr>
<tr>	<td>Times Viewed: <c:out value="${res.timesViewed}"/></td></tr>
<tr>		<td>Email: <c:out value="${res.email}"/></td></tr>
<tr>		<td>Contact Number: <c:out value="${res.contactNum}"/></td></tr>
<tr>		<td>Address: <c:out value="${res.address}"/></td></tr>
					
<table>
<tr>Resume Skills: </tr>
<c:forEach var="rs" items="${res.skills}">
<tr><c:out value="${rs}"></c:out></tr>
</c:forEach>


</table>
</table>		
		<table>	





</body>
</html>