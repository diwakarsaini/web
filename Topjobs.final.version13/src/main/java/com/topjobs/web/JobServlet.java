package com.topjobs.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topjobs.domain.Employer;
import com.topjobs.domain.User;
import com.topjobs.request.JobRequest;
import com.topjobs.service.JobService;

public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public JobServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobRequest jobRequest = new JobRequest();
		jobRequest.setJobName(request.getParameter("companyName"));
		jobRequest.setJobTitle(request.getParameter("jobTitle"));
		jobRequest.setJobDescription(request.getParameter("jobDesc"));
		
		String username = request.getRemoteUser();
		Employer employer = new Employer();
		employer.setUserName(username);
		
		jobRequest.setEmployer(employer);
		
		System.out.println(jobRequest.getJobName()+" "+jobRequest.getJobTitle()+" "+jobRequest.getJobDescription()+" "+jobRequest.getEmployer().getUserName());
		
		JobService jobService = new JobService();
		jobService.createNewJob(jobRequest);
		
		request.setAttribute("message", "Job has been Created!");
		request.getRequestDispatcher("NewJob").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
