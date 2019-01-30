package com.topjobs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class JobSeekerEvents {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "event_Sequence")
	@SequenceGenerator(name = "event_Sequence", sequenceName = "JobEVE_SEQ")
	private long eventId;
	@OneToOne
	private Job job;
	@OneToOne
	private JobSeeker jobSeeker;
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
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
	
	
}
