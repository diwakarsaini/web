package com.niit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@PrimaryKeyJoinColumn(name="user_name")
public class JobSeeker extends User {
	
	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JsonIgnore
	private Resume resume;
	private Boolean resumeCreated;
	
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public boolean isResumeCreated() {
		return resumeCreated;
	}
	public void setResumeCreated(Boolean resumeCreated) {
		this.resumeCreated = resumeCreated;
	}
	@Override
	public String toString() {
		return "JobSeeker [resume=" + resume + ", resumeCreated=" + resumeCreated + ", getUser_name()=" + getUser_name()
				+ ", getUser_pass()=" + getUser_pass() + ", getFname()=" + getFname() + ", getLname()=" + getLname()
				+ ", getUserRole()=" + getUserRole() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	

}
