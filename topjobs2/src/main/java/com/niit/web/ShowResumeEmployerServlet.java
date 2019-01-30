package com.niit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.domain.JobSeeker;
import com.niit.domain.User;
import com.niit.ro.ResumeRequest;
import com.niit.service.ResumeService;

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
		// TODO Auto-generated method stub
		
		
		JobSeeker jobSeeker=new JobSeeker();
		jobSeeker.setUser_name(request.getRemoteUser());
		ResumeRequest req=new ResumeRequest();
		
		//Resume rsm= new Resume();
		
		req.setJobSeeker(jobSeeker);
		
		ResumeService res=new ResumeService();
		
		req=res.viewResumeEmployer(req);
		
		request.setAttribute("resume", req);
		System.out.println(req);
		System.out.println("Resume of Employer Servlet Entered");
		request.getRequestDispatcher("/emp/showresume").forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
