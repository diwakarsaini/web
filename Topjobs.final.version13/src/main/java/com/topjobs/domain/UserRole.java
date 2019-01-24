package com.topjobs.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES", schema="TOPJOBS")
public class UserRole {


	
	@OneToMany(fetch=FetchType.EAGER)
	private Set<User> user = new HashSet<>();
	
	@Id
	private String user_name;
	private String role_name;
	
	
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public String getUserName() {
		return user_name;
	}
	public void setUserName(String userName) {
		this.user_name = userName;
	}
	public String getRoleName() {
		return role_name;
	}
	public void setRoleName(String roleName) {
		this.role_name = roleName;
	}
	
	
}
