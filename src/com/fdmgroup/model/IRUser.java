package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RUSERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="user.findByFullName", query="SELECT u FROM IRUser u WHERE u.status = TRUE AND "
					+ "LOWER(u.firstName) LIKE :fname OR LOWER(u.lastName) LIKE :lname "
					+ "OR LOWER(u.firstName) LIKE :lname OR LOWER(u.lastName) LIKE :fname "),
	@NamedQuery(name = "user.findAllUsers", query = "SELECT u FROM IRUser u WHERE u.status = TRUE")
})
public class IRUser extends IUser {
	@Column(name = "description")
	private String description;

	@Column(name = "firstName", length = 30)
	private String firstName;

	@Column(name = "lastName", length = 30)
	private String lastName;

	@Column(name = "email", unique = true)
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
	
	@OneToMany(mappedBy="requestUser")
    @Column(name="request")
    private List<Request> requests;

	public IRUser() {
		super();
		this.requests = new ArrayList<>();
	}

	public IRUser(String username, String password) {
		super(username, password);
		this.requests = new ArrayList<>();
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
		this.requests = new ArrayList<>();
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
		this.requests = new ArrayList<>();
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
		this.requests = new ArrayList<>();
	}

	public IRUser(String firstName, String lastName, String email, String phoneNumber, String city, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
		this.requests = new ArrayList<>();
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
		this.requests = new ArrayList<>();
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
		this.requests = new ArrayList<>();
	}

	public IRUser(String description, @NotNull(message = "user name can not be null") String username,
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
		this.requests = new ArrayList<>();
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

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	public void addRequestToUser(Request request){
		this.requests.add(request);
	}
	
	public void  removeRequestFromUser(Request request){
		this.requests.remove(request);
	}

	@Override
	public String toString() {
		return "IRUser [description=" + description + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", city=" + city + ", country=" + country + ", linkedInUrl="
				+ linkedInUrl + ", visibility=" + visibility + ", UserId=" + getUserId() + ", Username=" + getUsername()
				+ ", Status=" + isStatus() + ", Group=" + getGroup().getGroupName() + super.toString() + "]";
	}

}
