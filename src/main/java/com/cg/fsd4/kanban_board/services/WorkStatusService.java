package com.cg.fsd4.kanban_board.services;

import java.util.List;

import com.cg.fsd4.kanban_board.entity.TasksEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;


public interface WorkStatusService {
	
	public List<TasksEntity> getTask();
	
	public List<TeamMemberEntity> getAllTeamMember();
	
	public TasksEntity updateWorkStatus(Integer taskId, String workStatus);
	
	public TasksEntity updateTaskStatus(Integer taskId, String taskStatus);
	

}
