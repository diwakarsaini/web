package com.topjobs.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topjobs.domain.JobSeeker;
import com.topjobs.request.ResumeRequest;
import com.topjobs.service.ResumeService;

/**
 * Servlet implementation class ShowResumeJobSeekerServlet
 */
public class ShowResumeJobSeekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResumeJobSeekerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResumeRequest resumeRequest = new ResumeRequest();
		
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setUserName(request.getRemoteUser());
		
		resumeRequest.setJobSeeker(jobSeeker);
		
		ResumeService resumeService = new ResumeService();
		resumeRequest = resumeService.viewResumeJobSeeker(resumeRequest);
		
		request.setAttribute("resume",resumeRequest);
		System.out.println(resumeRequest);
		request.getRequestDispatcher("ShowResume").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
