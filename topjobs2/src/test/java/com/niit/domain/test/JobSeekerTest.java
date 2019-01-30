package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.niit.dao.JobSeekerDAO;
import com.niit.domain.JobSeeker;

class JobSeekerTest {

	@Test
	void testfindJobSeekerById() {
	JobSeekerDAO jsd=new JobSeekerDAO();
	JobSeeker js=new JobSeeker();
	js.setUser_name("a1");
	
	JobSeeker js1=jsd.findJobSeekerByUsername(js);
	System.out.println(js1.getUser_pass());
	}

}
