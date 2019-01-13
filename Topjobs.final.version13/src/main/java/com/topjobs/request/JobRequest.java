package com.topjobs.request;

import com.topjobs.domain.User;

public class JobRequest {

	private String jobName;
	private String jobTitle;
	private String jobDescription;
	private User jobUser;
	
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
	public User getJobUser() {
		return jobUser;
	}
	public void setJobUser(User jobUser) {
		this.jobUser = jobUser;
	}
	
	
	
}
