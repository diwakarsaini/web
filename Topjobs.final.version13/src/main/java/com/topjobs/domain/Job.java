package com.topjobs.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	
	@OneToOne(cascade = {CascadeType.ALL})
//	@JoinColumn(name= "user_name", 
//	referencedColumnName = "user_name")
	private Employer employer;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<JobSeeker> jobSeekers = new HashSet<>();
	
		
 
	@ManyToMany(cascade=CascadeType.ALL)
//    @JoinTable(
//        name = "Job_Skill", 
//        joinColumns = { @JoinColumn(name = "jobId") }, 
//        inverseJoinColumns = { @JoinColumn(name = "jobSkillId") }
//    )
	private Set<JobSkill> jobSkill = new HashSet<>();
	

	public Set<JobSkill> getJobSkill() {
		return jobSkill;
	}

	public void setJobSkill(Set<JobSkill> jobSkill) {
		this.jobSkill = jobSkill;
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
