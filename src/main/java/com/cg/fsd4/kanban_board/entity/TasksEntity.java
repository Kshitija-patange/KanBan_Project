package com.cg.fsd4.kanban_board.entity;

import javax.persistence.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tasks_info")
@JsonRootName("TasksEntity")
@JsonInclude(content = Include.NON_NULL)

public class TasksEntity {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;

	@Column
	@JsonProperty
	@NotNull
	private String taskName;

	@Column
	@JsonProperty
	@NotNull
	private String taskStatus;

	@Column
	@JsonProperty
	@NotNull
	private String workStatus;

	@ManyToOne
	@JoinColumn(name = "teamMemberId")
	@JsonIgnoreProperties("tasksList")
	private TeamMemberEntity teamMemberEntity;

	public TasksEntity() {
	}

	public TasksEntity(int taskId, @NotNull String taskName, @NotNull String taskStatus, @NotNull String workStatus, TeamMemberEntity teamMemberEntity) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		this.workStatus = workStatus;
		this.teamMemberEntity = teamMemberEntity;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public TeamMemberEntity getTeamMemberEntity() {
		return teamMemberEntity;
	}

	public void setTeamMemberEntity(TeamMemberEntity teamMemberEntity) {
		this.teamMemberEntity = teamMemberEntity;
	}

}
