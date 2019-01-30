package com.niit.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.domain.JobSeeker;
import com.niit.domain.User;
import com.niit.ro.ResumeRequest;
import com.niit.service.ResumeService;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		ResumeRequest req=new ResumeRequest();
		JobSeeker jobSeeker=new JobSeeker();
		jobSeeker.setUser_name(request.getRemoteUser());
		req.setJobSeeker(jobSeeker);
	
		ResumeService res=new ResumeService();
		req=res.viewResumeJobSeeker(req);
		request.setAttribute("resume", req);
		System.out.println(req);
		
		RequestDispatcher rd=request.getRequestDispatcher("/showresume");
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
