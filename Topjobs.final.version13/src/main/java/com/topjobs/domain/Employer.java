package com.topjobs.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "user_name")
public class Employer extends User {

	
	private boolean isActive;
	private int loginsPurchased;
	private Date purchaseDate;
	private Date endDate;
	
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getLoginsPurchased() {
		return loginsPurchased;
	}
	public void setLoginsPurchased(int loginsPurchased) {
		this.loginsPurchased = loginsPurchased;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	

	
	
	
}
