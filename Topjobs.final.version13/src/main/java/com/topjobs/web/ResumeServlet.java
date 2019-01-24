package com.topjobs.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topjobs.dao.JobSeekerDAO;
import com.topjobs.domain.Address;
import com.topjobs.domain.JobSeeker;
import com.topjobs.domain.JobSeekerMarks;
import com.topjobs.domain.Resume;
import com.topjobs.persistence.PersistenceManager;

/**
 * Servlet implementation class ResumeServlet
 */
public class ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResumeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobSeeker js = new JobSeeker();
		js.setUserName(request.getRemoteUser());
		
		JobSeekerDAO jDAO = new JobSeekerDAO();
		js = jDAO.jobSeekerUsernameFind(js);
		
		
		Resume rs = new Resume();
//		rs.setResumeId(902L);
		rs.setJobSeeker(js);;
		rs.setEmail(request.getParameter("email"));
		rs.setContactNumber(request.getParameter("email"));
		
		Address addr = new Address();
		addr.setAddressLine(request.getParameter("address"));
		addr.setCity(request.getParameter("inputCity"));
		addr.setState(request.getParameter("inputState"));
		addr.setPin(request.getParameter("inputZip"));
		
		rs.setAddress(addr);
		
		List<String> ls = new ArrayList<>();
		String[] arr = request.getParameterValues("skills");
		for(String s : arr) {
			ls.add(s);
		}
		rs.setSkills(ls);
		
		JobSeekerMarks jsmarks = new JobSeekerMarks();
		jsmarks.setMarks10(Double.valueOf(request.getParameter("marks10")));
		jsmarks.setMarks12(Double.valueOf(request.getParameter("marks12")));
		jsmarks.setGradMarks(Double.valueOf(request.getParameter("marksgrad")));
		
		rs.setJobSeekerMarks(jsmarks);
		
		ObjectMapper om = new ObjectMapper();
		
		String rStr = om.writeValueAsString(rs);
		System.out.println(rStr);
		rs.setResumeText(rStr);
		
		js.setResume(rs);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		em.merge(rs);
		em.getTransaction().commit();
		em.close();
	 
		request.getRequestDispatcher("JobSeekerLanding").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
