package com.niit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.JobSeekerEventsDAO;
import com.niit.domain.JobSeeker;
import com.niit.domain.JobSeekerEvents;

/**
 * Servlet implementation class AppliedJobs
 */
public class ShowAppliedJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAppliedJobsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setUser_name(request.getRemoteUser());
		JobSeekerEventsDAO jobSeekerEventsDAO = new JobSeekerEventsDAO();
		List<JobSeekerEvents> eventList = jobSeekerEventsDAO.findJobEventsByUsername(jobSeeker);
		request.setAttribute("eventList", eventList);
		request.getRequestDispatcher("/job/ShowAppliedJobs").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
