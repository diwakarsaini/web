package com.topjobs.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Enumeration<String> pNames =  request.getParameterNames();
		response.getWriter().append("Served at: 2").append(request.getContextPath());
		while(pNames.hasMoreElements()) {
			String param = pNames.nextElement();
			out.println(param);
			out.println(request.getParameter(param));
		}
		createConnection(request);
		//		request.getRequestDispatcher("RegistrationSuccessful").forward(request, response);
		
		out.println("<a href=\"LoginServlet\">Click to Login</a>");


	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	//JDBC Inserts
	private void createConnection(HttpServletRequest req) {

		String user_insert = "Insert into users(user_name,user_pass) VALUES(?,?)";
		String role_insert = "Insert into user_roles(user_name,role_name) VALUES(?,?)";
		try(	Connection con = getConnection();
				PreparedStatement user_insert_prepared =  con.prepareStatement(user_insert);
				PreparedStatement role_insert_prepared = con.prepareStatement(role_insert); ) {
			try {
				con.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {



				user_insert_prepared.setString(1, req.getParameter("email"));
				user_insert_prepared.setString(2, req.getParameter("pswd"));

				role_insert_prepared.setString(1, req.getParameter("email"));
				role_insert_prepared.setString(2, req.getParameter("role"));

				user_insert_prepared.executeUpdate();
				System.out.println("User is Created");
				System.out.println(req.getParameter("email") + "  " + req.getParameter("pswd"));

				role_insert_prepared.executeUpdate();
				System.out.println("Role is inserted");
				System.out.println(req.getParameter("email") + "  " + req.getParameter("role"));
				user_insert_prepared.close();
				role_insert_prepared.close();
				con.commit();

			} catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();

				}
				e.printStackTrace();


			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

		//Connection object
		private Connection getConnection() {
			final String DBCONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection con = null;

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");        	//load the class
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			try {
				con = DriverManager.getConnection(DBCONNECTION, "topjobs", "server99"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}

	}
