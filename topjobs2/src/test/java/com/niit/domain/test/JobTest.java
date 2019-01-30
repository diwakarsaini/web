package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.domain.Employer;
import com.niit.domain.Job;

import com.niit.domain.User;
import com.niit.topjobs.PersistenceManager;

class JobTest {

	@Test
	void testNewJob() throws IOException {

		Job job = new Job();
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction()
		.begin();
		job.setJobDescription("New JOB5"+Math.random());
		job.setJobName("CTS4");
		job.setJobTitle("JavaDev4");

		Employer user = new Employer();
		user.setUser_name("d2");
		job.setEmp(user);
		job.setPostedDate(new Date(119,0,01));
		em.persist(job);
		em.getTransaction()
		.commit();
		em.close();
		PersistenceManager.INSTANCE.close();	
	}

}
