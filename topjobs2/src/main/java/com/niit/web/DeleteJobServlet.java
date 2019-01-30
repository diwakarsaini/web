package com.niit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.JobDAO;
import com.niit.domain.Employer;
import com.niit.domain.Job;

/**
 * Servlet implementation class DeleteJobServlet
 */
public class DeleteJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String[] listJobs = request.getParameterValues("jobIds");
		for(String jobId:listJobs) {
			Job job = new Job();
			job.setJobId(Long.valueOf(jobId));
			JobDAO jDAO = new JobDAO();
			job = jDAO.findJobByID(job);
			jDAO.deleteJobById(job);
			request.getRequestDispatcher("/admin/ManageJobServlet").forward(request, response);
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
