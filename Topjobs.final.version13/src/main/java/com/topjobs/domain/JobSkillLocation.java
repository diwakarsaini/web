package com.topjobs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topjobs.domain.Job;

@Entity
public class JobSkillLocation {
	String skill;
	String loc;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "jobId")
	Job job;
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "jobSkill_loc_Sequence")
	@SequenceGenerator(name = "jobSkill_loc_Sequence", sequenceName = "JOBSKILL_LOC_SEQ")
	Long Id;

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}
