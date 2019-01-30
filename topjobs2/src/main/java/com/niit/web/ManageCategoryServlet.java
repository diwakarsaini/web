package com.niit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.JobDAO;
import com.niit.domain.Job;

/**
 * Servlet implementation class ManageCategoryServlet
 */
public class ManageCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		Long id = Long.valueOf(request.getParameter("jobId"));
		Job job = new Job();
		job.setJobId(id);
		JobDAO jDAO = new JobDAO();
		job = jDAO.findJobByID(job);
		job.setJobCategory(category);
		jDAO.merge(job);
		request.setAttribute("manage", "category");
		request.getRequestDispatcher("/admin/ManageJobServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
