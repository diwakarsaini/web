package com.niit.web;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.EmployerDAO;
import com.niit.dao.PurchaseEventsDAO;
import com.niit.domain.Employer;
import com.niit.domain.PurchaseEvents;

/**
 * Servlet implementation class FinalizePurchaseServlet
 */
public class FinalizePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizePurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("finalize");
		PurchaseEvents purchaseEvent = new PurchaseEvents();
		purchaseEvent.setEventId(Long.valueOf(request.getParameter("eventId")));
		PurchaseEventsDAO pDAO = new PurchaseEventsDAO();
		
		
		if(value.equals("Approve")) {
			
			purchaseEvent = pDAO.findPurchaseEventById(purchaseEvent);
			Employer emp = new Employer();
			emp.setUser_name(purchaseEvent.getEmployer().getUser_name());
			System.out.println(emp);
			EmployerDAO eDAO = new EmployerDAO();
			emp = eDAO.findEmployerByUsername(emp);
			System.out.println(emp);
			emp.setIsActive(true);
			emp.setLoginsPurchased(purchaseEvent.getLogins());
			emp.setPurchaseDate(new Date());
			if(emp.getEndDate()==null) {
				Date endDate = new Date(emp.getPurchaseDate().getTime()+TimeUnit.DAYS.toMillis(purchaseEvent.getLogins()*30));
				emp.setEndDate(endDate);
			}
			else if(emp.getEndDate()!=null) {
				Date endDate = new Date(emp.getEndDate().getTime()+TimeUnit.DAYS.toMillis(purchaseEvent.getLogins()*30));
				emp.setEndDate(endDate);
			}
			eDAO.merge(emp);
			pDAO.deletePurchaseEventById(purchaseEvent);
			
			
			request.getRequestDispatcher("/admin/ManagePurchasesServlet").forward(request, response);
		}
		if(value.equals("Delete")) {
			pDAO.deletePurchaseEventById(purchaseEvent);
			request.getRequestDispatcher("/admin/ManagePurchasesServlet").forward(request, response);
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
