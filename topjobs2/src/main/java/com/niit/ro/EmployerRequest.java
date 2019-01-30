package com.niit.ro;

import java.util.Date;

import com.niit.domain.Employer;

<<<<<<< HEAD
public class EmployerRequest extends UserRequest {

	private Employer emp;
	private Date purchasedate, enddate;
	private boolean isActive;
	private Long loginspurchased;
	
	
	public Employer getEmp() {
		return emp;
	}
	public void setEmp(Employer emp) {
		this.emp = emp;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Long getLoginspurchased() {
		return loginspurchased;
	}
	public void setLoginspurchased(Long loginspurchased) {
=======
public class EmployerRequest {

	Employer emp;
	Date purchasedate, enddate;
	boolean isActive;
	int loginspurchased;
	
	
	public Employer getEmp() {
		return emp;
	}
	public void setEmp(Employer emp) {
		this.emp = emp;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getLoginspurchased() {
		return loginspurchased;
	}
	public void setLoginspurchased(int loginspurchased) {
>>>>>>> branch 'master' of https://github.com/mathurshivang68/JAVA_EE
		this.loginspurchased = loginspurchased;
	}
	
	
	
}
