package com.topjobs.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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
	
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name= "user_name", 
	referencedColumnName = "user_name")
	private User user;
		
	@OneToMany(mappedBy = "job",cascade = {CascadeType.ALL})
	private List<JobSkillLocation> jskill = new ArrayList<JobSkillLocation>();
 
	public List<JobSkillLocation> getJskill() {
		return jskill;
	}

	public void setJskill(List<JobSkillLocation> jskill) {
		this.jskill = jskill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
