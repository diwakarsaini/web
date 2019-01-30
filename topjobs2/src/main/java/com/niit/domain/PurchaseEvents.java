package com.niit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PurchaseEvents {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "purchase_Sequence")
	@SequenceGenerator(name = "purchase_Sequence", sequenceName = "PUR_SEQ")
	private Long eventId;
	
	private Long logins;

	@OneToOne
	private Employer employer;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getLogins() {
		return logins;
	}

	public void setLogins(Long logins) {
		this.logins = logins;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	@Override
	public String toString() {
		return "PurchaseEvents [eventId=" + eventId + ", logins=" + logins + ", employer=" + employer + "]";
	}
	
	
	
}
