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
	

	
//	@JoinColumn(name= "JobSeekerFK", 
//	referencedColumnName = "user_name")
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private JobSeeker jobSeeker;
	
	@Transient
	private String name;
	
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
	
	@Column
	private long timesViewed;
	
	public Long getResumeId() {
		return resumeId;
	}
	public void setResumeId(Long i) {
		this.resumeId = i;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
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
	public Long getTimesViewed() {
		return timesViewed;
	}
	public void setTimesViewed(Long timesViewed) {
		this.timesViewed = timesViewed;
	}
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", jobSeeker=" + jobSeeker + ", name=" + name + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", address=" + address + ", skills=" + skills
				+ ", jobSeekerMarks=" + jobSeekerMarks + ", resumeText=" + resumeText + ", timesViewed=" + timesViewed
				+ "]";
	}
	
	
	
}
