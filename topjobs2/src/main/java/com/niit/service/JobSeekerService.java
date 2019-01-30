package com.niit.service;

import com.niit.dao.JobSeekerEventsDAO;
import com.niit.domain.JobSeekerEvents;
import com.niit.ro.JobApplyRequest;

public class JobSeekerService {   //JobSeekerEvent Service

	public void applyJob(JobApplyRequest req)
	{
		JobSeekerEvents jobSeekerEvent=new JobSeekerEvents();
		jobSeekerEvent.setEventId(req.getEventId());
		jobSeekerEvent.setJob(req.getJob());
		jobSeekerEvent.setJobSeeker(req.getJobSeeker());
		JobSeekerEventsDAO jobSeekerEventsDAO=new JobSeekerEventsDAO();
		jobSeekerEventsDAO.persist(jobSeekerEvent);
	}
	
	
	
	
}
