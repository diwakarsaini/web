package com.topjobs.service;

import com.topjobs.dao.JobSeekerEventsDao;
import com.topjobs.domain.JobSeekerEvents;
import com.topjobs.request.ApplyJobRequest;

public class JobSeekerService {

	public void applyJob(ApplyJobRequest req)
	{
		JobSeekerEvents jse=new JobSeekerEvents();
		jse.setJob(req.getJob());
		jse.setJobSeeker(req.getJobSeeker());
		JobSeekerEventsDao jeDAO=new JobSeekerEventsDao();
		jeDAO.persist(jse);
	}
}
