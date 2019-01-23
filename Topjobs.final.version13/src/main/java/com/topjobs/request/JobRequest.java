package com.topjobs.request;

import java.util.HashSet;
import java.util.Set;

import com.topjobs.domain.Employer;
import com.topjobs.domain.JobSeeker;

public class JobRequest {

	private String jobName;
	private String jobTitle;
	private String jobDescription;
	private Employer employer;
	private Set<JobSeeker> jobSeekers = new HashSet<>();
	
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
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Set<JobSeeker> getJobSeekers() {
		return jobSeekers;
	}
	public void setJobSeekers(Set<JobSeeker> jobSeekers) {
		this.jobSeekers = jobSeekers;
	}
	
	
	
	
	
}
