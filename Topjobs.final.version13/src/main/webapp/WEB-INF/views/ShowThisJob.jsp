<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<c:set var="job" value="<%=request.getAttribute("job") %>"/>

<table style="border: 1px solid black;">
			<tr>
				<td><c:out value="${job.jobName}"></c:out></td>
				<td><c:out value="${job.jobTitle}"></c:out></td>
				<td><c:out value="${job.jobDescription}"></c:out></td>	
				<td><input type="checkbox" name="jobs" value="${job.jobId}"></td>
			</tr>
</table>

</body>
</html>