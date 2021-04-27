package com.cg.fsd4.kanban_board.response;

import java.util.List;
import java.util.Optional;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TasksEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.entity.UserEntity;

public class KanbanBoardResponse {

	private String message;

	private UserEntity userEntity;
	private List<UserEntity> userList;

	private TeamLeadEntity teamLeadEntity;

	private TeamMemberEntity teamMemberEntity;
	private List<TeamMemberEntity> membersList;
	
	private List<ProjectEntity> projectList;

	private List<TasksEntity> tasks;
	
	

	public List<ProjectEntity> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectEntity> projectList) {
		this.projectList = projectList;
	}

	public List<TasksEntity> getTasks() {
		return tasks;
	}

	public void setTasks(List<TasksEntity> tasks) {
		this.tasks = tasks;
	}

	public List<TeamMemberEntity> getMembersList() {
		return membersList;
	}

	public void setMembersList(List<TeamMemberEntity> membersList) {
		this.membersList = membersList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserEntity getUserInfoBean() {
		return userEntity;
	}

	public void setUserInfoBean(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<UserEntity> getList() {
		return userList;
	}

	public void setList(List<UserEntity> userList) {
		this.userList = userList;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

	public TeamLeadEntity getTeamLeadEntity() {
		return teamLeadEntity;
	}

	public void setTeamLeadEntity(TeamLeadEntity teamLeadEntity) {
		this.teamLeadEntity = teamLeadEntity;
	}

	public TeamMemberEntity getTeamMemberEntity() {
		return teamMemberEntity;
	}

	public void setTeamMemberEntity(TeamMemberEntity teamMemberEntity) {
		this.teamMemberEntity = teamMemberEntity;
	}

}