package com.niit.domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
public class Resume {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "res_Sequence")
	@SequenceGenerator(name = "res_Sequence", sequenceName = "RES_SEQ")
	private Long resumeId;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	private JobSeeker jobSeeker;
	
	@Transient
	private String name;
	
	@Column
	private Long timesViewed;
	
	@Transient
	private String email;
	
	@Transient
	private String contactNum;
	
	@Transient
	private Address address;
		
	@Transient
	private List<String> skills;
	
	@Transient
	private JSMarks jsMarks;
	
	@Column(columnDefinition="varchar(1000)")
	private String resumeText;
	
	@JsonIgnore
	@Column(columnDefinition="varchar(1000)")
	public String getResumeText()  {
		
		return resumeText;
	}

	@JsonProperty
	public void setResumeText(String resumeText) throws JsonProcessingException {
		this.resumeText = resumeText;
	}

	public Long getResumeId() {
		return resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTimesViewed() {
		return timesViewed;
	}

	public void setTimesViewed(Long timesViewed) {
		this.timesViewed = timesViewed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
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

	public JSMarks getJsMarks() {
		return jsMarks;
	}

	public void setJsMarks(JSMarks jsMarks) {
		this.jsMarks = jsMarks;
	}
	
	
	
}
	