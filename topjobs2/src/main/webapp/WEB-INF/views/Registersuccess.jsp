

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TopJobs</title>
        <style>
        body {
        
                margin:50px 0px; padding:0px;
                text-align:center;
            }
        </style>  
    </head>
    <body style="background-color: lightsalmon">
        ${requestScope.supsuc}<br>
        <p>You have registered successfully with TOPJOBS as a <%=request.getParameter("role")  %></p>
        <a href="/topjobs/LoginServlet">Click here to login</a>
    </body>
</html>
