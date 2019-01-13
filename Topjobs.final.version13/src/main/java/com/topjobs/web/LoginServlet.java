package com.topjobs.web;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession(); 
		String username = request.getParameter("j_username");		//j_user and j_pass won't work. gives null
		String password = request.getParameter("j_password");
		String remoteUser = request.getRemoteUser();		// gives username of the user
		
		
		session.setAttribute("test", "helloooooo");			
		session.setAttribute("remoteUser", remoteUser);		
		
		if(request.isUserInRole("JobSeeker"))
		{	
			RequestDispatcher rd=request.getRequestDispatcher("/JobSeekerLanding");
			rd.forward(request, response); 
		}
		if(request.isUserInRole("Employer")) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("/EmployerLanding");
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
