package com.niit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.JobDAO;
import com.niit.domain.Job;

/**
 * Servlet implementation class ManageJobServlet
 */
public class ManageJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JobDAO jDAO = new JobDAO();
		List<Job> listJobs = jDAO.findAllJobs();
		request.setAttribute("listJobs", listJobs);
		if(request.getAttribute("manage")==null)
			request.setAttribute("manage", request.getParameter("manage"));
		
		if(request.getAttribute("manage").equals("job"))
		request.getRequestDispatcher("/admin/ManageJobs").forward(request, response);
		
		if(request.getAttribute("manage").equals("category"))
		request.getRequestDispatcher("/admin/ManageCategory").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
