<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="src\main\webapp\WEB-INF\CSS\TopjobsStyle.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Posting Page</title>
</head>
<body style="background-color: lightsalmon">

<header class="headerhome"></header>


<p><a href="logout">Logout</a></p>
<div class="row p-3 mb-2 bg-secondary text-primary">
<h>WELCOME EMPLOYER</h>

<div class="col-md-6">
<h1>My JOBS</h1>

<!List jobs after creating jobs !>

</div>

<div class="col-md-6">
<h2><a href="newJob">Create a new Job?</a></h2>
</div>

<!--  <a href="emp/ShowResumeEmployerServlet">SHOW RESUME</a> -->

<p><a href="/empjob">Show Jobs I have Posted</a></p>


<p><a href="emp/purchaselogin">Purchase Login</a></p>
</div>
</body>
</html>
