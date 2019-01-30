package com.niit.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.domain.JSMarks;
import com.niit.domain.JobSeeker;
import com.niit.domain.User;
import com.niit.ro.ResumeRequest;
import com.niit.service.ResumeService;
import com.niit.dao.JobSeekerDAO;
import com.niit.dao.ResumeDAO;
import com.niit.domain.Address;
import com.niit.domain.Resume;

/**
 * Servlet implementation class ResumeServlet
 */
public class ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobSeeker js = new JobSeeker();;
		js.setUser_name(request.getRemoteUser());
		JobSeekerDAO jDAO = new JobSeekerDAO();
		js = jDAO.findJobSeekerByUsername(js);
		
		Resume resume = new Resume();
		ResumeDAO rDAO = new ResumeDAO();
		ObjectMapper om = new ObjectMapper();
		
		String rStr;
		
		
		if(!js.isResumeCreated()) {
			js.setResumeCreated(true);
//			resume.setResumeId(902L);
			resume.setJobSeeker(js);
			resume.setName(request.getParameter("name"));
			resume.setEmail(request.getParameter("email"));
			resume.setContactNum(request.getParameter("contactNo"));
			
			Address address = new Address();
			address.setAddLine(request.getParameter("address"));
			address.setCity(request.getParameter("inputCity"));
			address.setState(request.getParameter("inputState"));
			address.setPin(request.getParameter("inputZip"));
			
			resume.setAddress(address);
			
			List<String> ls = new ArrayList<>();
			String[] arr = request.getParameterValues("skills");
			for(String s : arr) {
				ls.add(s);
			}
			resume.setSkills(ls);
			
			JSMarks jsmarks = new JSMarks();
			jsmarks.setMarks10(Double.valueOf(request.getParameter("marks10")));
			jsmarks.setMarks12(Double.valueOf(request.getParameter("marks12")));
			jsmarks.setGradMarks(Double.valueOf(request.getParameter("marksgrad")));
			
			resume.setJsMarks(jsmarks);

			rStr = om.writeValueAsString(resume);
			System.out.println(rStr);
			resume.setResumeText(rStr);
			resume.setTimesViewed(0L);
			js.setResume(resume);
			rDAO.merge(resume);
			
			resume = rDAO.viewResumeJobSeekerCreate(js);
			Resume newRs = om.readValue(resume.getResumeText(), Resume.class);
			newRs.setResumeId(resume.getResumeId());
			newRs.setJobSeeker(js);
			rStr = om.writeValueAsString(newRs);
			newRs.setResumeText(rStr);
			newRs.setTimesViewed(0L);
			js.setResume(newRs);
			rDAO.merge(newRs);
			
		} else {
			resume = rDAO.viewResumeJobSeekerCreate(js);
			Resume newRs = new Resume();
			newRs.setResumeId(resume.getResumeId());
			newRs.setJobSeeker(js);
			newRs.setName(request.getParameter("name"));
			newRs.setEmail(request.getParameter("email"));
			newRs.setContactNum(request.getParameter("contactNo"));
			
			Address addr = new Address();
			addr.setAddLine(request.getParameter("address"));
			addr.setCity(request.getParameter("inputCity"));
			addr.setState(request.getParameter("inputState"));
			addr.setPin(request.getParameter("inputZip"));
			
			newRs.setAddress(addr);
			
			List<String> ls = new ArrayList<>();
			String[] arr = request.getParameterValues("skills");
			for(String s : arr) {
				ls.add(s);
			}
			newRs.setSkills(ls);
			
			JSMarks jsmarks = new JSMarks();
			jsmarks.setMarks10(Double.valueOf(request.getParameter("marks10")));
			jsmarks.setMarks12(Double.valueOf(request.getParameter("marks12")));
			jsmarks.setGradMarks(Double.valueOf(request.getParameter("marksgrad")));
			newRs.setJsMarks(jsmarks);
			
			om = new ObjectMapper();
			rStr = om.writeValueAsString(newRs);
			newRs.setResumeText(rStr);
			js.setResume(newRs);

			rDAO.merge(newRs);
		}
	 
		request.getRequestDispatcher("/job/jsl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
