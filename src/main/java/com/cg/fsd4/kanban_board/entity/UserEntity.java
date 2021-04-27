package com.cg.fsd4.kanban_board.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@Entity
@Table(name = "user_info")
@JsonRootName("UserEntity")
@JsonInclude(content = Include.NON_NULL)

public class UserEntity implements Serializable { 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2040080006328156335L;

	@Id
	@JsonProperty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column
	@JsonProperty
	@NotNull
	private String userName;

	@Column
	@JsonProperty
	@NotNull
	@Email
	private String emailId;

	@Column
	@JsonProperty
	@NotNull
	private String password;

	@Column
	@JsonProperty
	@NotNull
	private String organisation; 
	
	@OneToMany(mappedBy="userEntity" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("userEntity")
	private List<ProjectEntity> projectList;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public boolean IsEmpty() {

		return false;
	}

}
