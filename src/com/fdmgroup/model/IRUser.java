package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "RUSERS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class IRUser extends IUser {
	
	@Column(name="description", length = 200)
	private String description;
	
	@Column(name = "firstName", length = 30)
	private String firstName;

	@Column(name = "lastName", length = 30)
	private String lastName;

	@Column(name = "email",  unique = true)
	private String email;

	@Column(name = "phoneNumber", length = 15)
	private String phoneNumber;

	@Column(name = "city", length = 30)
	private String city;

	@Column(name = "country", length = 20)
	private String country;

	@Column(name = "linkedIn")
	private String linkedInUrl;

	@Column(columnDefinition = "Number(1)")
	private boolean visibility = true;
	
	public IRUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public IRUser(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}



	public IRUser(String username, String password, String description, String firstName, String lastName, String email,
			String phoneNumber, String city, String country) {
		super(username, password);
		this.description = description;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
	}



	public IRUser(String username, String password, String description, String firstName, String lastName, String email,
			String phoneNumber, String city, String country, String linkedInUrl, boolean visibility) {
		super(username, password);
		this.description = description;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
		this.linkedInUrl = linkedInUrl;
		this.visibility = visibility;
	}



	public IRUser(String firstName, String lastName, String email, String phoneNumber, String city, String country,
			String linkedInUrl, boolean visibility) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
		this.linkedInUrl = linkedInUrl;
		this.visibility = visibility;
	}

	public IRUser(String firstName, String lastName, String email, String phoneNumber, String city, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
	}

	public IRUser(String firstName, String lastName, String email, String phoneNumber, String city, String country,
			boolean visibility) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
		this.visibility = visibility;
	}
	
	

	public IRUser(String description, String firstName, String lastName, String email, String phoneNumber, String city,
			String country, String linkedInUrl, boolean visibility) {
		super();
		this.description = description;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
		this.linkedInUrl = linkedInUrl;
		this.visibility = visibility;
	}

	
	
	public IRUser(String description,@NotNull(message = "user name can not be null") String username,
			@NotNull(message = "password can not be null") String password,
			@NotNull(message = "answer can not be null") String securityAnswer, String firstName, String lastName,
			String email, String phoneNumber, String city, String country) {
		
		super(username, password, securityAnswer);
		this.description = description;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "IRUser [description=" + description + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", city=" + city + ", country=" + country + ", linkedInUrl="
				+ linkedInUrl + ", visibility=" + visibility + "]";
	}

}

