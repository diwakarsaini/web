package com.topjobs.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.topjobs.dao.ResumeDAO;
import com.topjobs.domain.Resume;
import com.topjobs.request.ResumeRequest;

public class ResumeService {

	public void createResume(ResumeRequest obj) {
		Resume resume = new Resume();
		resume.setJobSeeker(obj.getJobSeeker());
		resume.setEmail(obj.getEmail());
		resume.setContactNumber(obj.getContactNumber());
		resume.setAddress(obj.getAddress());
		resume.setSkills(obj.getSkills());
		resume.setJobSeekerMarks(obj.getJobSeekerMarks());
		resume.setResumeText(obj.getResumeText());
		
		ResumeDAO rDAO = new ResumeDAO();
		rDAO.merge(resume);
	}

	public ResumeRequest viewResumeEmployer(ResumeRequest obj) throws JsonParseException, JsonMappingException, IOException {
		ResumeDAO rDAO = new ResumeDAO();
		Resume resume = rDAO.viewResumeEmployer(obj);

		ObjectMapper om = new ObjectMapper();
		ResumeRequest resumeReq = om.readValue(resume.getResumeText(), ResumeRequest.class);
//		resumeReq.setResumeId(resume.getResumeId());
		resumeReq.setTimesViewed(resume.getTimesViewed());
		return resumeReq;
	}
	
	public ResumeRequest viewResumeJobSeeker(ResumeRequest obj) throws JsonParseException, JsonMappingException, IOException {
		ResumeDAO rDAO = new ResumeDAO();
		Resume resume = rDAO.viewResumeJobSeeker(obj);

		ObjectMapper om = new ObjectMapper();
		ResumeRequest resumeReq = om.readValue(resume.getResumeText(), ResumeRequest.class);
//		resumeReq.setResumeId(resume.getResumeId());
		resumeReq.setTimesViewed(resume.getTimesViewed());
		return resumeReq;
	}

}



