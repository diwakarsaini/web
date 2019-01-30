package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.niit.dao.JobDAO;
import com.niit.domain.Employer;
import com.niit.domain.Job;

class DeleteJobTest {

	@Test
	void deleteJob() {
		
//		JobDAO jDAO = new JobDAO();
//		List<Job> listJobs = jDAO.findAllJobs();
//		Employer emp = new Employer();
//		emp.setUser_name("d2");
//		for(Job job : listJobs) {
//			
//			if(job.getEmp().getUser_name().equals(emp.getUser_name()))
//			{System.out.println(job);
//			jDAO.deleteJobById(job);
//			
//			}
//		}

		Job job = new Job();
		job.setJobId(1L);
		JobDAO jDAO = new JobDAO();
		job = jDAO.findJobByID(job);
		jDAO.deleteJobById(job);
	
	
	
	}
	
	
	

	
	@Test
	void datechexk() {
		Date date = new Date();
		Date date1 = new Date(119,0,20);
		System.out.println(date);
		System.out.println(date.getTime());
		System.out.println(date1);
		System.out.println(date1.getTime());

		Long milliseconds = date.getTime() - date1.getTime();
		long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
		
//		int days = (int) ((milliseconds / (1000*60*60*24)) % 7);
		
		System.out.println(milliseconds);
		System.out.println(days);

		System.out.println(days);

	}
	

}
