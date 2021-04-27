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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "team_Member_info")
@JsonRootName("TeamMemberEntity")
@JsonInclude(content = Include.NON_NULL)
public class TeamMemberEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6972681140745706752L;

	public TeamMemberEntity() {

	}

	@Id
	@JsonProperty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teamMemberId;

	@Column
	@JsonProperty
	@NotNull
	private String teamMemberName;

	@Column
	@JsonProperty
	@NotNull

	private long employeeId;

	@ManyToOne
	@JoinColumn(name = "projectId")
	@JsonIgnoreProperties("teamMemberList")
	private ProjectEntity projectEntity;

	@Column
	@JsonProperty
	@NotNull
	private String projectPassword;

	@OneToMany(mappedBy = "teamMemberEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("teamMemberEntity")
	private List<TasksEntity> tasksList;

	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		
		this.projectEntity = projectEntity;
		projectPassword = this.projectEntity.getProjectPassword();
	}

	public List<TasksEntity> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<TasksEntity> tasksList) {
		this.tasksList = tasksList;
	}

	public int getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(int teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public String getTeamMemberName() {
		return teamMemberName;
	}

	public void setTeamMemberName(String teamMemberName) {
		this.teamMemberName = teamMemberName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getProjectPassword() {
		return projectPassword;
	}

	public void setProjectPassword(String projectPassword) {
		this.projectPassword = projectPassword;
	}
}