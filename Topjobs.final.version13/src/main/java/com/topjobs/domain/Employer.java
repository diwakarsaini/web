package com.topjobs.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "user_name")
public class Employer extends User {

	
	private boolean isSupervisor;
	private boolean isActive;
	
//	private Set<Employer> juniors = new HashSet<>(); 
	
	
	
	
	public boolean getIsSupervisor() {
		return isSupervisor;
	}
	public void setIsSupervisor(boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	

	
	
	
}
