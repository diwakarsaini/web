package com.topjobs.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Resume {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "res_Sequence")
	@SequenceGenerator(name = "res_Sequence", sequenceName = "RESUME_SEQ")
	private Long resumeId;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name= "resume_user_name", 
	referencedColumnName = "user_name")
	private User user;
	
	@Transient
	private String email;
	
	@Transient
	private String contactNumber;
	
	@Transient
	private Address address;
	
	@Transient
	private List<String> skills;
	
	@Transient
	private JobSeekerMarks jobSeekerMarks;
	
	@JsonIgnore											// used when creating object from JSON, to avoid cycle
	@Column(columnDefinition="varchar(1000)")
	private String resumeText;
	
	
	public Long getResumeId() {
		return resumeId;
	}
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public JobSeekerMarks getJobSeekerMarks() {
		return jobSeekerMarks;
	}
	public void setJobSeekerMarks(JobSeekerMarks jobSeekerMarks) {
		this.jobSeekerMarks = jobSeekerMarks;
	}
	public String getResumeText() {
		return resumeText;
	}
	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}
	
	
	
}
