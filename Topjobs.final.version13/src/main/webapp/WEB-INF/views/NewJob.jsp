<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(request.getAttribute("message") != null){
		response.setContentType("text/html;charset=UTF-8");
		out.println("Job Created !!! <br>");
		out.println("<a href=\"EmployerLanding\">Home</a> <br>");
		out.println("Create new Job <br>");
		}
	%>
	<br>
	<form action="JobServlet" method="post"> 																<!job servlet> 
		Job Title: <input type="text" name="jobTitle" placeholder="jobTitle"> 
		<br>
		Company Name: <input type="text" name="companyName"> 
		<br>
		Job Description: <textarea rows="4" cols="50" name="jobDesc"></textarea>
		<br>
		<br>
		<div>
			Working City 1 <select>
				<option selected>Choose...</option>
				<option>Kolkata</option>
				<option>Chennai</option>
				<option>Bangalore</option>
				<option>Gurgaon</option>
				<option>Delhi</option>
				<option>Noida</option>
				<option>Kochi</option>
				<option>Chandigarh</option>
				<option>Jaipur</option>
			</select>
		</div>



		<div>
			Working State 2 <select>
				<option selected>Choose...</option>

				<option>Kolkata</option>
				<option>Chennai</option>
				<option>Bangalore</option>
				<option>Gurgaon</option>
				<option>Delhi</option>
				<option>Noida</option>
				<option>Kochi</option>
				<option>Chandigarh</option>
				<option>Jaipur</option>
			</select>
		</div>


		<div></div>

		<div>
			<label for="jobState3">Working State 3</label> <select>
				<option selected>Choose...</option>



				<option>Kolkata</option>
				<option>Chennai</option>
				<option>Bangalore</option>
				<option>Gurgaon</option>
				<option>Delhi</option>
				<option>Noida</option>
				<option>Kochi</option>
				<option>Chandigarh</option>
				<option>Jaipur</option>
			</select>
		</div>


		<div>
			<label for="salary">CTC Offered: </label> <input type="text">
		</div>


		<div>
			<label for="exp">Experience Required: </label> <input type="text">
		</div>

		<div>
			<p>
				<label for="jobskills">Please select the skills required for
					this job: </label>
			</p>

			Java <input type="checkbox" name="jobskills" value="java" /><br />

			C++ <input type="checkbox" name="jobskills" value="c++" /><br />

			Database <input type="checkbox" name="jobskills" value="database" /><br />

			Networking <input type="checkbox" name="jobskills" value="networking" />

			Digital Marketing <input type="checkbox" name="jobskills"
				value="digitalm" /><br /> Electronics <input type="checkbox"
				name="jobskills" value="electronics" /><br /> Mechanical <input
				type="checkbox" name="jobskills" value="mechanical" /><br />

			AutoCAD <input type="checkbox" name="jobskills" value="autocad" /><br />

			Big Data <input type="checkbox" name="jobskills" value="bigdata" /><br />

			HTML/CSS <input type="checkbox" name="jobskills" value="html" /><br />

		</div>

		<div>
			<button type="submit" class="btn btn-primary" value="SUBMIT">SUBMIT</button>
			<!job servlet>
		</div>
	</form>


</body>
</html>