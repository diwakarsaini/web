package com.topjobs.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topjobs.request.JobRequest;
import com.topjobs.service.JobService;

public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public JobServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		JobRequest jobRequest = new JobRequest();
		jobRequest.setJobName(request.getParameter("companyName"));
		jobRequest.setJobTitle(request.getParameter("jobTitle"));
		jobRequest.setJobDescription(request.getParameter("jobDesc"));
		System.out.println(jobRequest.getJobName()+" "+jobRequest.getJobTitle()+" "+jobRequest.getJobDescription());
		
		JobService jobService = new JobService();
		jobService.createNewJob(jobRequest);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("Job Created in Job Servlet");
		
		out.println("<a href=\"NewJob\">Create another Job</a>");
		out.println("<a href=\"EmployerLanding\">Home</a>");
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
