package com.niit.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.domain.Employer;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("LOGIN SERVLET ENTERED");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.isUserInRole("JobSeeker"))
		{	
			RequestDispatcher rd=request.getRequestDispatcher("/job/jsl");
			rd.forward(request, response);  
		}
		if(request.isUserInRole("Employer")) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("/emp/empl");
			rd.forward(request, response);
		}
		if(request.isUserInRole("Admin")) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("/admin/al");
			rd.forward(request, response);
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
