package com.niit.web;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.EmployerDAO;
import com.niit.domain.Employer;

/**
 * Servlet implementation class ShowAppicantServlet
 */
public class ShowApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowApplicantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employer emp = new Employer();
		emp.setUser_name(request.getRemoteUser());
		EmployerDAO employerDAO = new EmployerDAO();
		emp = employerDAO.findEmployerByUsername(emp);
		if(emp.getEndDate()!=null)
		if(emp.getEndDate().equals(new Date())) {
			emp.setIsActive(false);
			emp.setLoginsPurchased(0L);
			emp.setPurchaseDate(null);
			emp.setEndDate(null);
			employerDAO.merge(emp);
		}
		
		if(emp.getIsActive()) {
			
		}
		else {
			request.getRequestDispatcher("/emp/purchaselogin").forward(request, response);
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
