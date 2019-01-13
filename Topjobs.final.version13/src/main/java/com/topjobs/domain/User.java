package com.topjobs.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS", schema="TOPJOBS")
@Access(AccessType.FIELD)
public class User {

	@Id
	@Column(name="user_name")
	String user_name;
	
	@Column(name="user_pass")
	String user_pass;	
	
	
	public String getUserName() {
		return user_name;
	}

	public void setUserName(String userName) {
		this.user_name = userName;
	}

	public String getUserPass() {
		return user_pass;
	}

	public void setUserPass(String userPass) {
		this.user_pass = userPass;
	}
	
	
}
