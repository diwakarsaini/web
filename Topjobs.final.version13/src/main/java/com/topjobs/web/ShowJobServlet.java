package com.topjobs.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topjobs.domain.Job;
import com.topjobs.service.JobService;

/**
 * Servlet implementation class ShowJobServlet
 */
public class ShowJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowJobServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JobService jobService = new JobService();
		List<Job> jobList = jobService.getAllJobs();
		
		
		
		if(request.isUserInRole("Employer")) {
			List<Job> empJobs = new ArrayList<Job>();
			for(Job obj:jobList) {
				if(obj.getEmployer()!= null) {
					if(request.getRemoteUser().equals(obj.getEmployer().getUserName()))
					{	System.out.println(obj.getEmployer().getUserName());
						empJobs.add(obj);
					}
				}
			}
			if(empJobs.size()==0)
				request.setAttribute("JobList", jobList);
			else
				request.setAttribute("JobList", empJobs);
				
			
			request.getRequestDispatcher("ShowEmpJobs").forward(request, response);
		}
		
		if(request.isUserInRole("JobSeeker")) {
			request.setAttribute("JobList", jobList);
			request.getRequestDispatcher("ShowEmpJobs").forward(request, response);
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
