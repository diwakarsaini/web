<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Seeker Landing Page </title>
<link rel="stylesheet" type="text/css" href="C:\Users\Shivang\eclipse-workspace\topjobs\topjobs\src\main\webapp\WEB-INF\CSS\TopjobsStyle.css" />

</head>
<body style="background-color: lightsalmon">
<header class="headerhome"></header>

<p><a href="logout">Logout</a></p>
<div class="row p-3 mb-2 bg-secondary text-primary">
<h1> WELCOME JOB SEEKER</h1>

<div class="col-md-6">
<h2> Lets Make Your Resume Now</h2>
</body>

<p>Name: <%=request.getParameter("fname") %></p>
<p>Email: <%=request.getParameter("email") %></p>


<form id="resume" action="job/ResumeServlet">
  <div class=""row p-3 mb-2 bg-secondary text-primary">
    <div class="form-group col-md-6">
      <p><label for="name">Name:</label>
      <input type="text" class="form-control" name="name" placeholder="Full Name"></p>
    </div>

  <div class=""row p-3 mb-2 bg-secondary text-primary">
    <div class="form-group col-md-6">
      <p><label for="email">Email:</label>
      <input type="text" class="form-control" name="email" placeholder="Email ID"></p>
    </div>




  <div class=""row p-3 mb-2 bg-secondary text-primary">
    <div class="form-group col-md-6">
      <p><label for="contactNo">Contact No:</label>
      <input type="text" class="form-control" name="contactNo" placeholder="Contact Number"></p>
    </div>
    <div class="form-group col-md-6">
      <label for="resumeText">Resume Text</label>
      <textarea  rows="4" cols="50" name="resumeText" id="resumeText" form="resume">
    </textarea>
    </div>
   
  </div>
  <div class="form-group">
    <label for="address">Address</label>
     <textarea rows="4" cols="50" name="address" id="address" form="resume">
     </textarea>
  </div>

  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="inputCity">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" class="form-control">
        <option selected>Choose...</option>
  
        
<option>Andaman and Nicobar Islands</option>
<option>Andhra Pradesh</option>
<option>Arunachal Pradesh</option>
<option>Assam</option>
<option>Bihar</option>
<option>Chandigarh</option>
<option>Chhattisgarh</option>
<option>Dadra and Nagar Haveli</option>
<option>Daman and Diu</option>
<option>Delhi</option>
<option>Goa</option>
<option>Gujarat</option>
<option>Haryana</option>
<option>Himachal Pradesh</option>
<option>Jammu and Kashmir</option>
<option>Jharkhand</option>
<option>Karnataka</option>
<option>Kerala</option>
<option>Lakshadweep</option>
<option>Madhya Pradesh</option>
<option>Maharashtra</option>
<option>Manipur</option>
<option>Meghalaya</option>
<option>Mizoram</option>
<option>Nagaland</option>
<option>Orissa</option>
<option>Pondicherry</option>
<option>Punjab</option>
<option>Rajasthan</option>
<option>Sikkim</option>
<option>Tamil Nadu</option>
<option>Tripura</option>
<option>Uttaranchal</option>
<option>Uttar Pradesh</option>
<option>West Bengal</option>
</select>
        
        
        
        

  </div>
    <div class="form-group col-md-2">
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" name="inputZip">
    </div>
  </div>
  
<div>
<div class="form-group col-md-2">
 <label for="marks10">Marks in 10th: </label>
 <input type= "text" class="form-control" name="marks10">
 </div>
</div> 

<div>
<div class="form-group col-md-2">
 <label for="marks12">Marks in 12th: </label>
 <input type= "text" class="form-control" name="marks12">
 </div>
</div> 


<div>
<div class="form-group col-md-2">
 <label for="marksgrad">Marks in Graduation: </label>
 <input type= "text" class="form-control" name="marksgrad">
 </div>
</div> 

<div>
<div class="form-group col-md-2">
<p><label for="skills">Please select the skills you are proficient in: </label></p>

Java <input type="checkbox" name="skills" value="java"  /><br />

C++ <input type="checkbox" name="skills" value="c++"  /><br /> 

Database <input type="checkbox" name="skills" value="database"  /><br /> 

Networking <input type="checkbox" name="skills" value="networking"  />

Digital Marketing <input type="checkbox" name="skills" value="digitalm"  /><br /> 

Electronics <input type="checkbox" name="skills" value="electronics"  /><br /> 

Mechanical <input type="checkbox" name="skills" value="mechanical"  /><br /> 

AutoCAD <input type="checkbox" name="skills" value="autocad"  /><br /> 

Big Data <input type="checkbox" name="skills" value="bigdata"  /><br /> 

HTML/CSS <input type="checkbox" name="skills" value="html"  /><br /> 
</div>

  
 
  <button type="submit" class="btn btn-primary">SUBMIT</button>

</div>

</form>
<a href="/job/ShowResumeJobSeekerServlet">SHOW RESUME</a>

<td><form action="/topjobs/job/ShowResumeJobSeekerServlet" target="_blank">
					<input type="submit" value="SHOW"></form></td>
					

<a href="job/applyjob">APPLY JOBS</a>

</html>