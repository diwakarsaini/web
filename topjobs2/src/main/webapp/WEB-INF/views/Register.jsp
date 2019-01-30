<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


    <head>
        <meta http-equiv="Content-Type" content="text/html charset=UTF-8 name="viewport" content="width=device-width" initial-scale="1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            									 
												 
									
																							 										 
												 
        <title>TopJobs</title>
         <style>
            body {
                margin:50px 0px; padding:0px;
                text-align:center;
            }
            
			 
			 hr {	
 				border: 1px solid #f1f1f1;
				  margin-bottom: 25px;
				}
			 
			 .container {
  				padding: 16px;	
				}
			 
			 .btn {
  			background-color: #4CAF50;
  			color: white;
  			padding: 16px 20px;
 			margin: 8px 0;
			border: none;
  			cursor: pointer;
 			width: 60%;
  			opacity: 0.9;
}
			 
            .text
            {
            display: inline-block;
            -webkit-box-sizing: content-box;
            -moz-box-sizing: content-box;
             box-sizing: content-box;
            float: none;
            z-index: auto;
            width: auto;
            height: auto;   
            position: static;
            cursor: default;
            opacity: 1;
            margin: 0;
            padding: 6px 20px;
            overflow: visible;
            -webkit-border-radius: 32px / 54px;
            border-radius: 32px / 54px;
            font: normal 18px/normal "Coda", Helvetica, sans-serif;
            color: rgba(0,142,198,1);
            -o-text-overflow: ellipsis;
            text-overflow: ellipsis;
            background: rgba(252,252,252,1);    
            -webkit-box-shadow: 0 1px 2px 0 rgba(0,0,0,0.2) inset;
            box-shadow: 0 1px 2px 0 rgba(0,0,0,0.2) inset;
            text-shadow: 1px 1px 0 rgba(255,255,255,0.66) ;
            -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
            -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
            -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
            transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);
            -webkit-transform: none;
            transform: none;
            -webkit-transform-origin: 50% 50% 0;
            transform-origin: 50% 50% 0;            
           
            }
    
         fieldset{	border: 1px solid #ddd;
					padding: 0 1.4em 1.4em 1.4em;					   
					margin: 0 0 1.5em 0;					   
					border -radius: 80px;
					position: relative;
					margin:0 5px;
					margin:0 5px;					   
										   }
										   
										   
         .headerhome {
    background-image: url(logo-print.png);
    border-style: solid;
    border-color: #000000;
	border-									   
    position: fixed;
    height: 110px;
    width: 280px;
    left: 0px;
    top: 0px;
    right: 0px;
    bottom: auto;
}
       
										   
										   
		.navbar {
    align-self: auto;
    list-style-type: square;  
    align-items: flex-start;

    font-family: Cambria, "Hoefler Text", "Liberation Serif", Times, "Times New Roman", serif;
    font-size: medium;
    background-color: #984FC8;
    letter-spacing: normal;
    word-spacing: normal;
    display: block;
}
         </style>
<body>

<div class="col-md-6">
                
                
                
                
                <form action="RegisterServlet">
				<fieldset>
				
				
				<legend>Register</legend>
				
				
				<p>Fill out this form to Register</p>
				
				<hr>
				
				 <p>Register as 
                    	<input type="radio" name="role" value="JobSeeker" checked="checked" />JobSeeker
                        <input type="radio" name="role" value="Employer" />Employer</p>
			
				
				<p><label for="fname"><b>First Name</b></label>
					<input type="text" placeholder="Enter First Name" name="fname" required/></p>
				<p><label for="lname"><b>Last Name</b></label>
					<input type="text" placeholder="Enter Last Name" name="lname" required/></p>
					
					
				<p><label for="email"><b>Email</b></label>
					<input type="text" placeholder="Enter Email " name="email" required/></p>
					
				<p><label for="userid"><b>User ID</b></label>	
				<input type="text" placeholder="Enter Username" name="username" required/></p>
				
   				<p><label for="psw"><b>Password</b></label>
   				<input type="password" placeholder="Enter Password " name="pswd" required/></p>

<!--     			<p><label for="psw-repeat"><b>Repeat Password</b></label> -->
<!--     			<input type="password" placeholder="Repeat Password " name="psw-repeat" required/></p> -->
  			    
				<input type="submit" class="btn" value="Register"/>
 				<p>Already have an Account?<a href="LoginServlet"/>Sign In</a></p>
				
				</fieldset>
			</form>
	
			</div>

		
		
        
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>


</body>