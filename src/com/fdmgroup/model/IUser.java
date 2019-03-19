package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "USERS")
@DiscriminatorColumn(name="userType", discriminatorType=DiscriminatorType.STRING)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({ @NamedQuery(name = "iuser.findAllUser", query = "select u FROM IUser u"),
	@NamedQuery(name = "iuser.findAllByType", query = "select u FROM IUser u where TYPE(u) = :type"),
	@NamedQuery(name = "iuser.findAllRegularUsers", query = "select u FROM IUser u where TYPE(u) = :traineeType or Type(u) = :consultantType"),
	@NamedQuery(name = "iuser.loginUser", query = "select u FROM IUser u where u.username = :username")})

public class IUser {
	
	@Id
	@Column(name = "userId")
	@SequenceGenerator(name = "userSequence", sequenceName = "USER_ID_SEQ", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")

	private long userId;
	
	@Column(name="username", length = 30, nullable = false, unique = true)
	@NotNull(message = "user name can not be null")
	private String username;
	
	@Column(name = "password", length = 30, nullable = false)
	@NotNull(message = "password can not be null")
	private String password;
	
	@Column(columnDefinition = "Number(1)")
	private boolean status = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groupId")
	private Group group;
	
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

	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "IUser [userId=" + userId + ", username=" + username + ", password=" + password + ", status=" + status
				+ ", group=" + group + "]";
	}
	
	
}
