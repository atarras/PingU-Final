package com.fdmgroup.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Consultant")
public class Consultant extends IRUser{

	@Column(name = "currentTitle", length = 30, nullable = false)
	private String currentTitle;
	
	@Column(name = "employer", nullable = false)
	private String employer;
	
	@Column(name = "placementDate", nullable = false)
	private Date pDate;

	public Consultant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultant(String firstName, String lastName, String email, String phoneNumber, String city, String country,
			boolean visibility) {
		super(firstName, lastName, email, phoneNumber, city, country, visibility);
		// TODO Auto-generated constructor stub
	}

	public Consultant(String firstName, String lastName, String email, String phoneNumber, String city, String country,
			String linkedInUrl, boolean visibility) {
		super(firstName, lastName, email, phoneNumber, city, country, linkedInUrl, visibility);
		// TODO Auto-generated constructor stub
	}

	public Consultant(String firstName, String lastName, String email, String phoneNumber, String city,
			String country) {
		super(firstName, lastName, email, phoneNumber, city, country);
		// TODO Auto-generated constructor stub
	}

	public String getCurrentTitle() {
		return currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		this.currentTitle = currentTitle;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	@Override
	public String toString() {
		return "Consultant [currentTitle=" + currentTitle + ", employer=" + employer + ", pDate=" + pDate + "]";
	}
	
	
	
}
