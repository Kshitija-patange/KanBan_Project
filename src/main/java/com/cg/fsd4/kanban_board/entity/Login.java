package com.cg.fsd4.kanban_board.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * The Class Login.
 */

@AllArgsConstructor
@NoArgsConstructor
public class Login {
	// @NotNull(message="email must not be empty")
	private String emailId;
	// @NotEmpty(message="Password must not be empty")
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return emailId;
	}

	public void setEmail(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}