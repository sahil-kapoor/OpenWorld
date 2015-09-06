package com.openworld.domain;

import java.util.Calendar;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class UserCreateForm {

	@NotEmpty
	private String email = "";
	
	@NotEmpty
	private String login = "";

	@NotEmpty
	private String password = "";

	@NotEmpty
	private String passwordRepeated = "";

	@NotNull
	private Role role = Role.USER;

	@NotNull
	private Calendar createDate = Calendar.getInstance();;

	private String firstName = "";

	private String lastName = "";
	
	

	@Override
	public String toString() {
		return "UserCreateForm{" + "email='" + email.replaceFirst("@.+", "@***") + '\'' + ", password=***" + '\''
				+ ", passwordRepeated=***" + '\'' + ", role=" + role + '}';
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
