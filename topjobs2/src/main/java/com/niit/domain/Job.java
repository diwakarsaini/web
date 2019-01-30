package com.niit.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "job_Sequence")
	@SequenceGenerator(name = "job_Sequence", sequenceName = "JOB_SEQ")
	private Long jobId;
	
	@Column
	private String jobName;
	
	@Column
	private String jobTitle;

	@Column
	private String jobDescription;
	
	@OneToOne
	private Employer emp;
	
	@Column
	private Date postedDate;

	@Column
	private String jobCategory;
	
	@Transient
	private Long elapsedDays;
	
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

	public Employer getEmp() {
		return emp;
	}

	public void setEmp(Employer emp) {
		this.emp = emp;
	}

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

	public Long getElapsedDays() {
		Date date = getPostedDate();
		Long milliseconds = System.currentTimeMillis() - date.getTime();
		Long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
		return days;
	}

	public void setElapsedDays(Long elapsedDays) {
		this.elapsedDays = elapsedDays;
	}

}
