package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "Trainee")
public class Trainee extends IRUser {

	@Column(name = "stream", length = 30)
	private String stream;
	
	@Column(name = "currentTitle", length = 30)
	private String currentTitle;
	

	public Trainee() {
		super();
		this.currentTitle = "Trainee";
	}

	public Trainee(String username, String password, String stream) {
		super(username, password);
		this.stream = stream;
		this.currentTitle = "Trainee";
	}

	public Trainee(String username, String password, String description, String firstName, String lastName,
			String email, String phoneNumber, String city, String country, String stream) {
		super(username, password, description, firstName, lastName, email, phoneNumber, city, country);
		this.stream = stream;
		this.currentTitle = "Trainee";
	}

	public Trainee(String firstName, String lastName, String email, String phoneNumber, String city, String country,
			boolean visibility) {
		super(firstName, lastName, email, phoneNumber, city, country, visibility);
		this.currentTitle = "Trainee";
		// TODO Auto-generated constructor stub
	}

	public Trainee(String firstName, String lastName, String email, String phoneNumber, String city, String country,
			String linkedInUrl, boolean visibility) {
		super(firstName, lastName, email, phoneNumber, city, country, linkedInUrl, visibility);
		this.currentTitle = "Trainee";
		// TODO Auto-generated constructor stub
	}

	public Trainee(String firstName, String lastName, String email, String phoneNumber, String city, String country) {
		super(firstName, lastName, email, phoneNumber, city, country);
		this.currentTitle = "Trainee";
		// TODO Auto-generated constructor stub
	}

	public Trainee(String description, String firstName, String lastName, String email, String phoneNumber, String city,
			String country, String linkedInUrl, boolean visibility) {
		super(description, firstName, lastName, email, phoneNumber, city, country, linkedInUrl, visibility);
		this.currentTitle = "Trainee";
		// TODO Auto-generated constructor stub
	}

	public Trainee(String description, @NotNull(message = "user name can not be null") String username,
			@NotNull(message = "password can not be null") String password,
			@NotNull(message = "answer can not be null") String securityAnswer, String firstName, String lastName,
			String email, String phoneNumber, String city, String country, String stream) {
		super(description, username, password, securityAnswer, firstName, lastName, email, phoneNumber, city, country);
		this.currentTitle = "Trainee";
		this.stream = stream;
	}

	public Trainee(String stream) {
		super();
		this.currentTitle = "Trainee";
		this.stream = stream;
	}

	public String getCurrentTitle()
	{
		return currentTitle;
	}
	
	public void setCurrentTitle(String currentTitle)
	{
		this.currentTitle = currentTitle;
	}
	
	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Trainee [Stream=" + stream + ", First Name=" + getFirstName() + ", Last Name=" + getLastName()
				+ ", Email=" + getEmail() + ", Phone Number=" + getPhoneNumber() + ", City=" + getCity() + ", Country="
				+ getCountry() + ", LinkedInUrl=" + getLinkedInUrl() + ", Visibility=" + isVisibility()
				+ ", Description=" + getDescription() + ", UserId=" + getUserId() + ", Username=" + getUsername()
				+ ", Status=" + isStatus() + ", Group=" + getGroup().getGroupName() + "]";
	}

}
