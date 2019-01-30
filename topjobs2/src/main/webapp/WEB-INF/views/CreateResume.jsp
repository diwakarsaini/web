<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> Lets Make Your Resume Now</h2>

<p>Hello <%=request.getRemoteUser() %>

<form action="ResumeServlet" method="post">
      Name:
      <input type="text" name="name" placeholder="Full Name">
<br>
     Email:
      <input type="text" name="email" placeholder="Email ID">
<br>
      Contact No:
      <input type="text" name="contactNo" placeholder="Contact Number">
    <br>  
   
      Address:
      <textarea rows="4" cols="50" name="address"></textarea>
<br>
      City:
      <input type="text" name="inputCity">
    <br>  
      State:
      <select name="inputState" >
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
<br>
		Zip:
      <input type="text"  name="inputZip">
<br>
		Marks in 10th:
 	  <input type= "text"  name="marks10">
<br>
	    Marks in 12th: 
	  <input type= "text"  name="marks12">
<br>
		Marks in Graduation: 
	  <input type= "text"  name="marksgrad">
<br>
		Please select the skills you are proficient in: 
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
		
		  
 
  <button type="submit">SUBMIT</button>


</form>












</body>
</html>