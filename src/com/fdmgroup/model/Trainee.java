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

	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Trainee(String username, String password, String stream) {
		super(username, password);
		this.stream = stream;
	}



	public Trainee(String username, String password, String description, String firstName, String lastName,
			String email, String phoneNumber, String city, String country, String stream) {
		super(username, password, description, firstName, lastName, email, phoneNumber, city, country);
		this.stream = stream;
	}



	public Trainee(String firstName, String lastName, String email, String phoneNumber, String city, String country,
			boolean visibility) {
		super(firstName, lastName, email, phoneNumber, city, country, visibility);
		// TODO Auto-generated constructor stub
	}

	public Trainee(String firstName, String lastName, String email, String phoneNumber, String city, String country,
			String linkedInUrl, boolean visibility) {
		super(firstName, lastName, email, phoneNumber, city, country, linkedInUrl, visibility);
		// TODO Auto-generated constructor stub
	}

	public Trainee(String firstName, String lastName, String email, String phoneNumber, String city, String country) {
		super(firstName, lastName, email, phoneNumber, city, country);
		// TODO Auto-generated constructor stub
	}
	
	

	public Trainee(String description, String firstName, String lastName, String email, String phoneNumber, String city,
			String country, String linkedInUrl, boolean visibility) {
		super(description, firstName, lastName, email, phoneNumber, city, country, linkedInUrl, visibility);
		// TODO Auto-generated constructor stub
	}
	
	

	public Trainee(String description, @NotNull(message = "user name can not be null") String username,
			@NotNull(message = "password can not be null") String password,
			@NotNull(message = "answer can not be null") String securityAnswer, String firstName, String lastName,
			String email, String phoneNumber, String city, String country, String stream) {
		super(description, username, password, securityAnswer, firstName, lastName, email, phoneNumber, city, country);
		this.stream = stream;
	}



	public Trainee(String stream) {
		super();
		this.stream = stream;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Trainee [stream=" + stream + "]";
	}

}

