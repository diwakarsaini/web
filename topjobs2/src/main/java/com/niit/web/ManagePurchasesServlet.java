package com.niit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.PurchaseEventsDAO;
import com.niit.domain.PurchaseEvents;

/**
 * Servlet implementation class ManagePurchasesServlet
 */
public class ManagePurchasesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePurchasesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PurchaseEventsDAO purchaseEventsDAO = new PurchaseEventsDAO();
		List<PurchaseEvents> purchaseList = purchaseEventsDAO.findAllPurchaseEvents();
		request.setAttribute("purchaseList", purchaseList);
		request.getRequestDispatcher("/admin/ManagePurchases").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
