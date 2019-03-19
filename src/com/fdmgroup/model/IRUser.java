package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "RUSERS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class IRUser extends IUser {

	@Column(name = "firstName", length = 30, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 30, nullable = false)
	private String lastName;

	@Column(name = "email", length = 30, nullable = false)
	private String email;

	@Column(name = "phoneNumber", length = 15, nullable = false)
	private String phoneNumber;

	@Column(name = "city", length = 30, nullable = false)
	private String city;

	@Column(name = "country", length = 20, nullable = false)
	private String country;

	@Column(name = "linkedIn")
	private String linkedInUrl;

	@Column(columnDefinition = "Number(1) default '1'")
	private boolean visibility;

	public IRUser() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "IRUser [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", city=" + city + ", country=" + country + ", linkedInUrl=" + linkedInUrl
				+ ", visibility=" + visibility + "]";
	}

}
