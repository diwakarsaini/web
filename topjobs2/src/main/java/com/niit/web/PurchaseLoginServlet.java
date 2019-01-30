package com.niit.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.niit.dao.EmployerDAO;
import com.niit.dao.PurchaseEventsDAO;
import com.niit.domain.Employer;
import com.niit.domain.PurchaseEvents;
import com.niit.ro.EmployerRequest;
import com.niit.service.JobService;

/**
 * Servlet implementation class PurchaseLoginServlet
 */
public class PurchaseLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Employer emp=new Employer();
		emp.setUser_name(request.getRemoteUser());
		EmployerDAO eDAO = new EmployerDAO();
		emp = eDAO.findEmployerByUsername(emp);
		
		PurchaseEvents purchaseEvents = new	PurchaseEvents();
		purchaseEvents.setEmployer(emp);
		purchaseEvents.setLogins(Long.valueOf(request.getParameter("logins")));
		PurchaseEventsDAO purchaseEventsDAO = new PurchaseEventsDAO();
		purchaseEventsDAO.persist(purchaseEvents);
		
		System.out.println("PURCHASE LOGIN SERVLET ENTERED");
		RequestDispatcher rd=request.getRequestDispatcher("/emp/empl");  //Employer landing page
=======
import com.niit.domain.Employer;
import com.niit.ro.EmployerRequest;
import com.niit.service.JobService;

/**
 * Servlet implementation class PurchaseLoginServlet
 */
public class PurchaseLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Employer emp=new Employer();
		emp.setUserName(request.getRemoteUser());
		
		EmployerRequest req=new EmployerRequest();
		req.setEmp(emp);
		req.setLoginspurchased(Integer.valueOf(request.getParameter("logins")));
		req.setPurchasedate(new Date());
		
		
		JobService js=new JobService();
		
		js.purchaseLogin(req);
	
		System.out.println("PURCHASE LOGIN SERVLET ENTERED");
		RequestDispatcher rd=request.getRequestDispatcher("/emp/empl");  //apply jobs page forward
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE
		rd.forward(request,response);
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
