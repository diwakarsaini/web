package com.topjobs.service;


import java.util.List;

import com.topjobs.dao.JobDAO;
import com.topjobs.domain.Job;
import com.topjobs.request.JobRequest;

public class JobService {

	public void createNewJob(JobRequest obj) {
		Job job = new Job();
		job.setJobName(obj.getJobName());
		job.setJobTitle(obj.getJobTitle());
		job.setJobDescription(obj.getJobDescription());
		
		JobDAO jDAO = new JobDAO();
		jDAO.persist(job);
	}
	
	public List<Job> getAllJobs() {
		JobDAO jDAO=new JobDAO();
		return jDAO.findAllJobs();
	}
	
}
