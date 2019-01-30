package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD
import com.niit.dao.JobDAO;
=======
import com.niit.dao.EmployerDao;
import com.niit.dao.JobsDao;
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE
import com.niit.domain.Employer;
import com.niit.domain.Job;
import com.niit.domain.JobSeeker;
import com.niit.domain.JobSeekerEvents;
import com.niit.domain.User;
import com.niit.ro.JobRequest;
import com.niit.topjobs.PersistenceManager;

import junit.framework.Assert;

class JobsDaoTest {

	@Test
	void testPersist() throws JsonParseException, JsonMappingException, IOException {
		JobDAO jd= new JobDAO();
		Job job=new Job();
		job.setJobDescription("Putin Job");
		job.setJobName("CTS Ltd");
		job.setJobTitle("Developer");
<<<<<<< HEAD

		Employer user=new Employer();
		user.setUser_name("uname2");
		user.setUser_pass("pwd2");
		job.setEmp(user);
		jd.persist(job);
	}
=======
		
		
		JobSkillLoc jsl=new JobSkillLoc();
		JobSkillLoc jsl2=new JobSkillLoc();
		
		jsl.setLoc("Delhi");
		jsl2.setLoc("Pune");
		
		jsl.setJob(job);
		jsl.setSkill("C++");
		jsl2.setSkill("Java");
		
		jsl2.setJob(job);
		
		
		List ls=new ArrayList();
		
		ls.add(jsl);
		ls.add(jsl2);
		
		job.setJskill(ls);
		
		User user=new User();
		  user.setUserName("putin");
		    user.setUserPass("12345");
		    job.setUser(user);
		    
		    ObjectMapper objectMapper = new ObjectMapper();
		    
		    String jobAsString = objectMapper.writeValueAsString(job);
		    Job job1 = objectMapper.readValue(jobAsString, Job.class);
		    
		    
		    job.setUser(user);
			
			jd.persist(job);
		
		
			}
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE


	@Test
	void testFindAllJobs(){
		JobDAO jd = new JobDAO();
		List<Job> js = jd.findAllJobs();
		Assert.assertTrue(js.size()>0);	
	}


	@Test
	void testFindJobById()
	{
		JobDAO jd=new JobDAO();
		Job req=new Job();
		req.setJobId(502L);
		Job js=jd.findJobByID(req);
		System.out.println(js);
	}


	@Test
	void testFindJobByIdEager()
	{
		JobDAO jd=new JobDAO();
		Job job=new Job();
		job.setJobId(202L);
		Job js=jd.findJobByIdEager(job);
	}


	@Test
	void testFindAppliedJobs()
	{
		JobDAO jd=new JobDAO();
		JobSeekerEvents job=new JobSeekerEvents();
		JobSeeker user=new JobSeeker();
		JobSeekerEvents jse=new JobSeekerEvents();
		user.setUser_name("gyan");
		jse.setJobSeeker(user);

		List<JobSeekerEvents> js=jd.getAppliedJobs(user);

		Assert.assertTrue(js.size()>0);	
		System.out.println(js.size());

	}
	@Test
	public void findJobSeekerByID(JobSeeker jobs) {



		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		JobSeeker entity=em.find(JobSeeker.class, "pracheer");
		em.getTransaction().commit();
		em.close();
		System.out.println(entity);
	}

	@Test
	public void testViewJobByEmployer()  //jobs by this employer
	{
		Employer emp=new Employer();
		emp.setUser_name("d2");
		JobDAO jd=new JobDAO();

		List<Job> jobs=jd.viewJobByEmployer(emp);
		for(Job job:jobs) {
			System.out.println(job);
		}
		//		Assert.assertTrue(jobs.size()>0);	
		//				System.out.println(jobs.size());


	}
	
	@Test
	public void testPurchaseLogin()
	{
		Employer empl=new Employer();
		empl.setUserName("trump");
		empl.setUserPass("12345");
		
		EmployerDao empd=new EmployerDao();
		empd.PurchaseLogin(empl);
		
		
		
		
	}
	
	
	
}
