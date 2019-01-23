package com.topjobs.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERS", schema="TOPJOBS")
@Access(AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED)
public class User {

	@Id
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_pass")
	private String userPass;	
	
	private String fName;
	private String lName;
	
	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="userRoleFK")
	private UserRole userRole;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPass=" + userPass + ", userRole=" + userRole + "]";
	}

	
	
}
