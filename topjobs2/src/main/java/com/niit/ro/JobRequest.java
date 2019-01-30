package com.niit.ro;

import java.util.Date;

import com.niit.domain.Employer;
import com.niit.domain.User;

public class JobRequest {
	private String jobName;
	private String jobTitle;
	private String jobDescription;
	private Long jobId;
	private Employer emp;
	private Date postedDate;
	private String jobCategory;
	
	
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	public Employer getEmp() {
		return emp;
	}
	public void setEmp(Employer emp) {
		this.emp = emp;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	
	
}
