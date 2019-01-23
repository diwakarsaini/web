package com.topjobs.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topjobs.domain.JobSeeker;
import com.topjobs.domain.User;
import com.topjobs.request.ResumeRequest;
import com.topjobs.service.JobService;
import com.topjobs.service.ResumeService;

/**
 * Servlet implementation class ShowResumeEmployerServlet
 */
public class ShowResumeEmployerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResumeEmployerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResumeRequest resumeRequest = new ResumeRequest();
		
		JobSeeker js = new JobSeeker();
		js.setUserName(request.getRemoteUser());
		
		resumeRequest.setJobSeeker(js);
		
		ResumeService resumeService = new ResumeService();
		resumeRequest = resumeService.viewResumeEmployer(resumeRequest);
		
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
