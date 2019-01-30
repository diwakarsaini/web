<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="C:\Users\Shivang\eclipse-workspace\topjobs\topjobs\src\main\webapp\WEB-INF\CSS\TopjobsStyle.css" />
</head>
<body style="background-color: lightsalmon">
<header class="headerhome"></header>

<div class="row p-3 mb-2 bg-secondary text-primary">
<h1>Lets Create a New Job</h1> 
</div>

<form id="newjob" action="/topjobs/emp/JobServlet"> 																								 <!job servlet>
  <div class=""row p-3 mb-2 bg-secondary text-primary">
    <div class="form-group col-md-6">
      <p><label for="jobTitle">Job Title:</label>
      <input type="text" class="form-control" name="jobTitle" placeholder="jobTitle"></p>
    </div>
    
  </div>
  <div class="form-group">
    <label for="companyName">Company Name:</label>
    <input type="text" class="form-control" name="companyName" form="newjob">
     
  </div>

<div class="form-group col-md-6">
      <label for="jobDesc">Job Description</label>
      <textarea  rows="4" cols="50" name="jobDesc" id="jobDesc" form="newjob">
    </textarea>
    </div>
   <br>
   
    Job Category: <select name="jobCategory">
    			  <option selected>Administrative</option>
    			  <option>Finance</option>
    			  <option>IT</option>
    			  </select>

 
  <button type="submit" class="btn btn-primary" value="SUBMIT">SUBMIT</button>  														<!job servlet>


</form>

<p><a href="/topjobs/emp/ShowJobServlet">Show Jobs I have Posted</a></p>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</body>
</html>