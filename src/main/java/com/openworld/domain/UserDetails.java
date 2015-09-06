package com.openworld.domain;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "user_detail")

public class UserDetails {

	
	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "user"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false)
	private Long userId;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	/*
	 * @Column(name = "image") private "Image" image;
	 */

	public UserDetails() {
	}

	public UserDetails(Long userId, User user, String last_name, String first_name) {
		this.userId = userId;
		this.user = user;
		this.lastName = last_name;
		this.firstName = first_name;
	}

	@Override
	public String toString() {
		return "UserDetails{" + "id=" + userId + ", last_name='" + lastName + ", first_name='" + firstName
				+ '}';
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
