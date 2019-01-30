package com.topjobs.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topjobs.dao.JobDAO;
import com.topjobs.dao.JobSeekerDAO;
import com.topjobs.domain.Job;
import com.topjobs.domain.JobSeeker;
import com.topjobs.request.ApplyJobRequest;
import com.topjobs.service.JobSeekerService;

public class ApplyJobServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ApplyJobServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ApplyJobRequest applyJobReq = new ApplyJobRequest();
		
		String[] jobIdList = request.getParameterValues("jobs");
		
		JobSeeker js = new JobSeeker();
		js.setUserName(request.getRemoteUser());
		JobSeekerDAO jDAO = new JobSeekerDAO();
		js = jDAO.jobSeekerUsernameFind(js);
		
		Job job = new Job();
		JobDAO jobDAO = new JobDAO(); 
		
		for(String id:jobIdList)
		{
			job.setJobId(Long.valueOf(id));
			job = jobDAO.findJobByID(job);
			applyJobReq.setJob(job);
			applyJobReq.setJobSeeker(js);
			JobSeekerService jss=new JobSeekerService();
			jss.applyJob(applyJobReq);
		}



		System.out.println("APPLYJOB SERVLET ENTERED");

		RequestDispatcher rd=request.getRequestDispatcher("/showapplyjob");

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
