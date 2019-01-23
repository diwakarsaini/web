package com.topjobs.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="user_name")
public class JobSeeker extends User {
	
	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="resumeFk")
	private Resume resume;

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "JobSeeker [resume=" + resume + ", username=" + getUserName() + ", password=" + getUserPass()
				+ ", userRole=" + getUserRole() + "]";
	}
	
	
	
}
