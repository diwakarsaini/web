package com.topjobs.request;

import com.topjobs.domain.Job;
import com.topjobs.domain.JobSeeker;

public class ApplyJobRequest {

	private long eventId;
	private Job job;
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
