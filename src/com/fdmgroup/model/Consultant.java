package com.fdmgroup.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value="Consultant")
public class Consultant extends IRUser{

	@Column(name = "currentTitle", length = 30)
	private String currentTitle;
	
	@Column(name = "employer")
	private String employer;
	
	@Column(name = "placementDate")
	private Date pDate;

	public Consultant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Consultant(String username, String password, String currentTitle, String employer, Date pDate) {
		super(username, password);
		this.currentTitle = currentTitle;
		this.employer = employer;
		this.pDate = pDate;
	}



	public Consultant(String username, String password, String description, String firstName, String lastName,
			String email, String phoneNumber, String city, String country, String currentTitle, String employer,
			Date pDate) {
		super(username, password, description, firstName, lastName, email, phoneNumber, city, country);
		this.currentTitle = currentTitle;
		this.employer = employer;
		this.pDate = pDate;
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
	
	

	public Consultant(String description, @NotNull(message = "user name can not be null") String username,
			@NotNull(message = "password can not be null") String password,
			@NotNull(message = "answer can not be null") String securityAnswer, String firstName, String lastName,
			String email, String phoneNumber, String city, String country, String currentTitle, String employer,
			Date pDate) {
		super(description, username, password, securityAnswer, firstName, lastName, email, phoneNumber, city, country);
		this.currentTitle = currentTitle;
		this.employer = employer;
		this.pDate = pDate;
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

