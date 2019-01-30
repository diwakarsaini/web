<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.niit.domain.Job" %> 
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
    
<!DOCTYPE html>
<html>
<head>
<script language="javascript">
function perc1() {
	var price=300, finalcost=0;
	
<<<<<<< HEAD
	  discount = <%=getServletContext().getInitParameter("discountValue")%>
=======
	  discount= <%= pageContext.getServletConfig().getInitParameter("discount1") %>
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE
	logins = document.discountcalc.logins.value;
	 /* discount = document.discountcalc.discount.value; */
	 discountperc=(100-discount)/100;
	 

	 
	 if(logins>3)
	 {
		finalcost=(logins*price*discountperc);	 
	 }
	 else{
		 finalcost=logins*price;	 
	 }
	 
	 document.discountcalc.finalcost.value = finalcost
	 
	 
	 
	 }
	
	</script>
	<body>
	<h1>Purchase additional Logins</h1>
<h2>One Login is valid for 30 Days </h2>

<<<<<<< HEAD
<h6>Note: Get Discount of 30% on fees if you purchase 6 or more Logins</h6>
=======
<h6>Note: Get Discount of 30% on fees if you purchase 3 or more Logins</h6>
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE
<!--   getServletContext().getInitParameter("discount")  -->

	
	
	
<<<<<<< HEAD
<%--    <%=getServletContext().getInitParameter("discountValue") %> --%>
=======
   <%= pageContext.getServletConfig().getInitParameter("discount1") %>
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE

<%-- 	<%= config.getInitParameter("discount1") %>  --%>  
	
	
	<FORM name="discountcalc" method="post" action="/topjobs/emp/PurchaseLoginServlet">
	<TABLE cellSpacing=1 cellPadding=1 border=1>
	  <TBODY>
	  <TR>
	    <TD align=middle colSpan=3><B><FONT size=4>Discount Calculator</FONT></B> 
	      </TD>
	  <tr>
	
	   <label for="logins">No of Logins:</label>
      <select name="logins" class="form-control">
        <option selected>Choose...</option>
  
        
  
<option value="1">1 month</option>
<option value="3">3 months</option>
<option value="6">6 months</option>
<option value="12">12 months</option>	  
	  
	  </select>
	  </tr>
	  	
	  	<!-- <td>No of Logins: <input size=5 name=logins ></TD>-->
	    <!-- <td>Discount: <input size=5 name=discount> </td> -->
	    
	    <td>Final Rate: <input maxLength=40 size=5 name=finalcost></td>
	    <td><input onclick=perc1() type=button value=Calculate></td>
	  <TR>
	    <TD align=middle 
	colSpan=3><INPUT type=reset value=Reset></TD></TR></TBODY></TABLE>
	
	
	<button type="submit" class="btn btn-primary" value="PAY">PAY</button> 
	




</form>

</body>
</head>
</html>