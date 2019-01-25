package com.topjobs.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="user_name")
public class JobSeeker extends User {
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name="resumeFk")
	private Resume resume;
	private boolean resumeCreated;
	
	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public boolean isResumeCreated() {
		return resumeCreated;
	}

	public void setResumeCreated(boolean resumeCreated) {
		this.resumeCreated = resumeCreated;
	}

	
}
