package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.niit.dao.JobSeekerEventsDAO;
import com.niit.domain.Job;
import com.niit.domain.JobSeeker;
import com.niit.domain.JobSeekerEvents;
import com.niit.domain.User;
import com.niit.ro.JobApplyRequest;
import com.niit.service.JobSeekerService;

class JobEventDaoTest {

	@Test
	void test() {
	JobSeekerEventsDAO	jed=new JobSeekerEventsDAO();
	JobSeekerEvents jobSeekerEvents=new JobSeekerEvents();
	Job job=new Job();
	job.setJobId(102L);
	jobSeekerEvents.setJob(job);
	JobSeeker jobSeeker=new JobSeeker();
	jobSeeker.setUser_name("shivang");
	jobSeekerEvents.setJobSeeker(jobSeeker);
	
	jed.persist(jobSeekerEvents);
	}

	
		
	
	
}
