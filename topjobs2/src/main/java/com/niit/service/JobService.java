/**
 * 
 */
package com.niit.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

<<<<<<< HEAD
import com.niit.dao.EmployerDAO;
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
import com.niit.ro.EmployerRequest;
import com.niit.ro.JobRequest;
import com.niit.topjobs.PersistenceManager;

/**
 * @author Shivang
 *
 */
public class JobService {
	
	public void createANewJob(JobRequest req) {
		Job job = new Job();
		job.setJobName(req.getJobName());
		job.setJobTitle(req.getJobTitle());
		job.setJobDescription(req.getJobDescription());
		job.setEmp(req.getEmp());
		job.setPostedDate(new Date());
		job.setJobCategory(req.getJobCategory());
		JobDAO jobDAO = new JobDAO();
		jobDAO.persist(job);
		
	}

	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		JobDAO jd=new JobDAO();
		return jd.findAllJobs();
		
	}

	public Job showJobById(Job job)
	{		
		JobDAO jd=new JobDAO();
		return jd.findJobByIdEager(job);
	}
		
	public List<JobSeekerEvents> showAppliedJobs(JobSeeker jobs)
	{
		JobDAO jd=new JobDAO();
		return jd.getAppliedJobs(jobs);
	}
	
	public List<Job> showEmployerJobs(Employer emp)
	{
		JobDAO jd=new JobDAO();
		return jd.viewJobByEmployer(emp);
	}

	
	public void purchaseLogin(EmployerRequest req)
	{
		
		
		Employer emp=new Employer();
<<<<<<< HEAD
		emp.setUser_name(req.getEmp().getUser_name());
		emp.setPurchaseDate(req.getPurchasedate());
		emp.setIsActive(req.isActive());
		emp.setLoginsPurchased(req.getLoginspurchased());
		
		EmployerDAO empd=new EmployerDAO();
		empd.purchaseLogin(emp);
=======
		emp.setUserName(req.getEmp().getUserName());
		emp.setPurchaseDate(req.getPurchasedate());
		emp.setActive(req.isActive());
		emp.setLoginsPurchased(req.getLoginspurchased());
		
		EmployerDao empd=new EmployerDao();
		empd.PurchaseLogin(emp);
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE
		
	}

}
	

	