package com.topjobs.domain;

public class JobSeekerMarks {

	private Double marks10;
	private Double marks12;
	private Double gradMarks;
	public Double getMarks10() {
		return marks10;
	}
	public void setMarks10(Double marks10) {
		this.marks10 = marks10;
	}
	public Double getMarks12() {
		return marks12;
	}
	public void setMarks12(Double marks12) {
		this.marks12 = marks12;
	}
	public Double getGradMarks() {
		return gradMarks;
	}
	public void setGradMarks(Double gradMarks) {
		this.gradMarks = gradMarks;
	}
	@Override
	public String toString() {
		return "marks10=" + marks10 + ", marks12=" + marks12 + ", gradMarks=" + gradMarks;
	}
	
	
	
}
