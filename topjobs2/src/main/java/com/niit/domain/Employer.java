package com.niit.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "user_name")
public class Employer extends User{

<<<<<<< HEAD
	private Boolean isActive;
	private Long loginsPurchased;
	private Date purchaseDate;
	private Date endDate;
	public Boolean getIsActive() {
=======
	boolean isActive;
	int loginsPurchased;
	Date purchaseDate;
	Date endDate;
	
	
	public boolean isActive() {
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Long getLoginsPurchased() {
		return loginsPurchased;
	}
	public void setLoginsPurchased(Long loginsPurchased) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((loginsPurchased == null) ? 0 : loginsPurchased.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employer other = (Employer) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (loginsPurchased == null) {
			if (other.loginsPurchased != null)
				return false;
		} else if (!loginsPurchased.equals(other.loginsPurchased))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employer [isActive=" + isActive + ", loginsPurchased=" + loginsPurchased + ", purchaseDate="
				+ purchaseDate + ", endDate=" + endDate + ", getUser_name()=" + getUser_name() + ", getUser_pass()="
				+ getUser_pass() + ", getFname()=" + getFname() + ", getLname()=" + getLname() + ", getUserRole()="
				+ getUserRole() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
