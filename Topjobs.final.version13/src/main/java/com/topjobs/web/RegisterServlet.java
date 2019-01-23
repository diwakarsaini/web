package com.topjobs.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topjobs.dao.RegisterDAO;
import com.topjobs.domain.Address;
import com.topjobs.domain.Admin;
import com.topjobs.domain.Employer;
import com.topjobs.domain.JobSeeker;
import com.topjobs.domain.JobSeekerMarks;
import com.topjobs.domain.Resume;
import com.topjobs.domain.User;
import com.topjobs.domain.UserRole;
import com.topjobs.exceptions.RegistrationFailedException;
import com.topjobs.persistence.PersistenceManager;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employer emp;
		JobSeeker js;
		Admin admin;
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String userName = request.getParameter("email");
		String pass = request.getParameter("pswd");

		UserRole ur = new UserRole();
		ur.setUserName(userName);
		ur.setRoleName(request.getParameter("role"));


		try {
			if(request.getParameter("role").equals("Employer")) {
				emp = new Employer();
				emp.setfName(fName);
				emp.setlName(lName);
				emp.setUserName(userName);
				emp.setUserPass(pass);
				emp.setIsActive(true);
				emp.setIsSupervisor(true);
				emp.setUserRole(ur);
				registerUser(emp);

			} 

			if(request.getParameter("role").equals("JobSeeker")) {
				js = new JobSeeker();
				js.setfName(fName);
				js.setlName(lName);
				js.setUserName(userName);
				js.setUserPass(pass);
				js.setUserRole(ur);
				
//				Resume rs = new Resume();
//				
//				
////				rs.setResumeId(852L);
////				rs.setJobSeeker(js);
//				rs.setEmail("diwakar94@gmail.com");
//				rs.setContactNumber("8447849901");
//				Address addr = new Address();
//				addr.setAddressLine("3951. Ahiran Street");
//				addr.setCity("Delhi");
//				addr.setState("Delhi");
//				addr.setPin(110006);
//				
//				rs.setAddress(addr);
//				
//				List<String> ls = new ArrayList<>();
//				ls.add("java");
//				ls.add("c++");
//				ls.add("html");
//				ls.add("hiberate");
//				
//				rs.setSkills(ls);
//				
//				JobSeekerMarks jsmarks = new JobSeekerMarks();
//				jsmarks.setMarks10(98.7);
//				jsmarks.setMarks12(99.5);
//				jsmarks.setGradMarks(99.99);
//				
//				rs.setJobSeekerMarks(jsmarks);
//				
//				System.out.println(rs);
//				
//				ObjectMapper om = new ObjectMapper();
//				
//				String rStr = om.writeValueAsString(rs);
//				System.out.println(rStr);
//				rs.setResumeText(rStr);
//				rs.setJobSeeker(js);
//				js.setResume(rs);
				
				
				
				
				
				registerUser(js);
			} 

			if(request.getParameter("role").equals("Admin")) {
				admin = new Admin();
				admin.setfName(fName);
				admin.setlName(lName);
				admin.setUserName(userName);
				admin.setUserPass(pass);
				admin.setUserRole(ur);
				registerUser(admin);
			} 
			
		}
		catch (RegistrationFailedException e) {
			request.setAttribute("exception", e.getMessage());
			request.getRequestDispatcher("Homepage").forward(request, response);
		}
		
		request.getRequestDispatcher("/RegistrationSuccessful").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}


	private void registerUser(User user) throws RegistrationFailedException {
		RegisterDAO rDAO = new RegisterDAO();
		try {
			rDAO.persist(user);
		}catch(Exception e) {
			throw new RegistrationFailedException("Registration failed.");
		}
	}


















	//==========================================================================================================
	//JDBC Inserts
	//	private void createConnection(HttpServletRequest req) throws RegistrationFailedException {
	//
	//		String user_insert = "Insert into users(user_name,user_pass) VALUES(?,?)";
	//		String role_insert = "Insert into user_roles(user_name,role_name) VALUES(?,?)";
	//		try(	Connection con = getConnection();
	//				PreparedStatement user_insert_prepared =  con.prepareStatement(user_insert);
	//				PreparedStatement role_insert_prepared = con.prepareStatement(role_insert); ) {
	//			try {
	//				con.setAutoCommit(false);
	//			} catch (SQLException e1) {
	//				e1.printStackTrace();
	//			}
	//
	//			try {
	//
	//
	//
	//				user_insert_prepared.setString(1, req.getParameter("email"));
	//				user_insert_prepared.setString(2, req.getParameter("pswd"));
	//
	//				role_insert_prepared.setString(1, req.getParameter("email"));
	//				role_insert_prepared.setString(2, req.getParameter("role"));
	//
	//				user_insert_prepared.executeUpdate();
	//				System.out.println("User is Created");
	//				System.out.println(req.getParameter("email") + "  " + req.getParameter("pswd"));
	//
	//				role_insert_prepared.executeUpdate();
	//				System.out.println("Role is inserted");
	//				System.out.println(req.getParameter("email") + "  " + req.getParameter("role"));
	//				user_insert_prepared.close();
	//				role_insert_prepared.close();
	//				con.commit();
	//
	//			} catch (SQLException e) {
	//				try {
	//					con.rollback();
	//					throw new RegistrationFailedException("Registration failed. User already exist.");
	//				} catch (SQLException e1) {
	//					e1.printStackTrace();
	//
	//				}
	//				e.printStackTrace();
	//
	//
	//			}
	//		} catch (SQLException e2) {
	//			// TODO Auto-generated catch block
	//			e2.printStackTrace();
	//		}
	//	}
	//
	//		//Connection object
	//		private Connection getConnection() {
	//			final String DBCONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	//			Connection con = null;
	//
	//			try {
	//				Class.forName("oracle.jdbc.driver.OracleDriver");        	//load the class
	//			} catch (ClassNotFoundException e1) {
	//				e1.printStackTrace();
	//			}
	//
	//			try {
	//				con = DriverManager.getConnection(DBCONNECTION, "topjobs", "server99"); 
	//			} catch (SQLException e) {
	//				e.printStackTrace();
	//			}
	//			return con;
	//		}

}
