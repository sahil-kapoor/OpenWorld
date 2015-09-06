package com.openworld.domain;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "login"),
		@UniqueConstraint(columnNames = "email") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private Long userId;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private UserDetails userDetails;

	@Column(name = "login", nullable = false, unique = true)
	private String login;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	private Calendar createDate;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
	}

	public User(Long userId, String login, String email, String passwordHash, Calendar createDate) {
		this.userId = userId;
		this.login = login;
		this.email = email;
		this.passwordHash = passwordHash;
		this.createDate = createDate;
	}

	public User(Long userId, UserDetails userDetails, String login, String email, String passwordHash,
			Calendar createDate) {
		this.userId = userId;
		this.userDetails = userDetails;
		this.login = login;
		this.email = email;
		this.passwordHash = passwordHash;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + userId + ", email='" + email.replaceFirst("@.*", "@***") + ", passwordHash='"
				+ passwordHash.substring(0, 10) + '}';

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
