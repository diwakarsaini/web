package com.niit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class JobSeekerEvents {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "event_Sequence")
	@SequenceGenerator(name = "event_Sequence", sequenceName = "EVE_SEQ")
	private Long eventId;
	
	@OneToOne(cascade= {CascadeType.MERGE})
	//	@JoinColumn(name="jobId",referencedColumnName = "jobId")
	private Job job;

	@OneToOne(cascade= {CascadeType.MERGE})
	//	@JoinColumn(name="user_name", referencedColumnName = "user_name")
	private JobSeeker jobSeeker;

	

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}



}
