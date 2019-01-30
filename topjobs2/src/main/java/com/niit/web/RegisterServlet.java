package com.niit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.RegisterDAO;
import com.niit.domain.Address;
import com.niit.domain.Employer;
import com.niit.domain.JobSeeker;
import com.niit.domain.Resume;
import com.niit.domain.User;
import com.niit.domain.UserRole;
/**
 * Servlet implementation class Register
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name=request.getParameter("username");
		String user_pass=request.getParameter("pswd");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");

		UserRole ur=new UserRole();

		ur.setUser_name(user_name);
		ur.setRole_name(request.getParameter("role"));

		if(request.getParameter("role").equals("JobSeeker"))
		{
			JobSeeker js=new JobSeeker();
			js.setFname(fname);
			js.setLname(lname);
			js.setUser_name(user_name);
			js.setUser_pass(user_pass);
			js.setUserRole(ur);
			js.setResumeCreated(false);
			RegisterUser(js);	
		}
<<<<<<< HEAD

		if(request.getParameter("role").equals("Employer"))
		{	
			Employer emp=new Employer();
			emp.setFname(fname);
			emp.setLname(lname);
			emp.setUser_name(user_name);
			emp.setUser_pass(user_pass);
			emp.setIsActive(false);
			emp.setUserRole(ur);
			RegisterUser(emp);
		}

=======
		
		 if(request.getParameter("role").equals("Employer"))
		 {	
			 Employer emp=new Employer();
			 emp.setFname(fname);
			 emp.setLname(lname);
			 emp.setUserName(user_name);
			 emp.setUserPass(user_pass);
			 emp.setActive(false);
			 emp.setUserRole(ur);
			 
			 RegisterUser(emp);
						 
	 	 }
		
		 
		
		
		
		
		//
		
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE
		RequestDispatcher rd=request.getRequestDispatcher("/regs"); 		//MAKE REGISTERSUCCESS PAGE 
		rd.forward(request, response);  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 

	{
		doGet(request, response);
	}
	
	private void RegisterUser(User user)
	{
		RegisterDAO rDao=new RegisterDAO();
		rDao.persist(user);
	}


	//JDBC statements	

	//	
	//	private void printAllParameters(HttpServletRequest request, PrintWriter pw) {
	//		pw.println("Parameters");
	//		
	//		
	//			
	//			String p = request.getParameter("fname");
	//			
	//			String p1 = request.getParameter("lname");
	//			
	//			String p2 = request.getParameter("email");
	//			
	//			String p3 = request.getParameter("psw");
	//			pw.println("FirstName: "+p+" "+"LastName: "+p1+"Email: "+p2+"Password: "+p3);
	//		
	//		
	//		}
	//	private void MyCon(HttpServletRequest request) throws SQLException, ClassNotFoundException{

	///JD

	//		String insertTableSQL = "INSERT INTO USERS"
	//				+ "(USER_NAME,USER_PASS) VALUES"
	//				+ "(?,?)";
	//		String insertRole = "INSERT INTO USER_ROLES"
	//				+ "(USER_NAME,ROLE_NAME) VALUES"
	//				+ "(?,?)";
	//		String insertDesc = "INSERT INTO USER_DESC"
	//				+ "(FNAME, LNAME, EMAIL) VALUES"
	//				+ "(?,?,?)";
	//		
	//		Class.forName("oracle.jdbc.driver.OracleDriver");
	//		final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	//		final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	//		
	//		Connection con=null;
	//		try {
	//			
	//			 con = DriverManager.getConnection(DB_CONNECTION,"topjobs", "1234");
	//			PreparedStatement preparedStatement = null;
	//			PreparedStatement preparedStatement1 = null;
	//			PreparedStatement preparedStatement2 = null;
	//			
	//			preparedStatement =con.prepareStatement(insertTableSQL);
	//			preparedStatement.setString(1,request.getParameter("userid"));
	//			preparedStatement.setString(2,request.getParameter("psw"));
	//			
	//			preparedStatement1 =con.prepareStatement(insertRole);
	//			preparedStatement1.setString(1,request.getParameter("userid"));
	//			preparedStatement1.setString(2,request.getParameter("role"));
	//
	//			preparedStatement2 =con.prepareStatement(insertDesc);
	//			preparedStatement2.setString(1,request.getParameter("fname"));
	//			preparedStatement2.setString(2,request.getParameter("lname"));
	//			preparedStatement2.setString(3,request.getParameter("email"));
	//
	//			
	//			preparedStatement.executeUpdate();
	//			preparedStatement1.executeUpdate();
	//			preparedStatement2.executeUpdate();
	//			
	//			System.out.println("Record is inserted into USER table!");
	//			preparedStatement1.executeUpdate();
	//			System.out.println("Record is inserted into USER Role table!");
	//			preparedStatement2.executeUpdate();
	//			System.out.println("Record is inserted into User Desc table!");
	//			
	//		} catch (SQLException e) {
	//			System.out.println(e.getMessage());
	//
	//		
	//}


	



}
