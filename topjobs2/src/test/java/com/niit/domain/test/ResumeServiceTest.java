package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.niit.domain.JSMarks;
import com.niit.domain.JobSeeker;
import com.niit.domain.User;
import com.niit.ro.ResumeRequest;
import com.niit.service.ResumeService;

class ResumeServiceTest {

	@Test
	void ServiceTest() throws JsonProcessingException
	{
		ResumeService rs=new ResumeService();
		ResumeRequest req=new ResumeRequest();
		
		JobSeeker jobSeeker=new JobSeeker();
		jobSeeker.setUser_name("Shivang");
		req.setJobSeeker(jobSeeker);
		req.setEmail("mathurs@gmail.com");
		req.setContactNum("9182828299");
		
		JSMarks marks=new JSMarks();
		marks.setMarks10(80.0);
		marks.setMarks12(85.0);
		marks.setGradMarks(88.0);
		req.setJsMarks(marks);
		
		List skills=new ArrayList<>();
		skills.add("C++");
		skills.add("HTML");
		req.setSkills(skills);
		
		rs.createANewResume(req);
	}

}
