package com.niit.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.domain.Job;
import com.niit.domain.JobSeeker;
import com.niit.domain.User;
import com.niit.ro.JobApplyRequest;
import com.niit.service.JobSeekerService;

/**
 * Servlet implementation class ApplyJobServlet
 */
public class ApplyJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplyJobServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		JobApplyRequest req=new JobApplyRequest();
		String[] jobIdList=request.getParameterValues("jobs");
		List<String> jobslist=new ArrayList<String>();
		for(String s:jobIdList)
		{

			JobSeeker jobSeeker=new JobSeeker();
			jobSeeker.setUser_name(request.getRemoteUser());
			
			Job job=new Job();

			job.setJobId(Long.valueOf(s));
			req.setJob(job);
			req.setJobSeeker(jobSeeker);

			JobSeekerService jss=new JobSeekerService();
			jss.applyJob(req);
		}



		System.out.println("APPLYJOB SERVLET ENTERED");

		RequestDispatcher rd=request.getRequestDispatcher("/LoginServlet");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
