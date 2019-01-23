package com.topjobs.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class JobSkill {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "job_skill_Sequence")
	@SequenceGenerator(name = "job_skill_Sequence", sequenceName = "JOBSKILL_SEQ")
	private long jobSkillId;
	
	private String skill;
	
	@ManyToMany
	@JsonIgnore
	private Set<Job> job = new HashSet<>();

	

	
	
	
}
