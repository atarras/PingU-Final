package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
@DiscriminatorColumn(name="userType", discriminatorType=DiscriminatorType.STRING)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class IUser {
	
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name="username", length = 30, nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", length = 30, nullable = false)
	private String password;
	
	@Column(columnDefinition = "Number(1) default '0'")
	private boolean status;

	public IUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IUser(String username, String password, boolean status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
	}

	public IUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "IUser [userId=" + userId + ", username=" + username + ", password=" + password + ", status=" + status
				+ "]";
	}
	
	
}
