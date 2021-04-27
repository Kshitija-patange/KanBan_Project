package com.cg.fsd4.kanban_board.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fsd4.kanban_board.entity.TasksEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.repo.TasksRepo;
import com.cg.fsd4.kanban_board.repo.TeamMemberRepo;

@Service
@Transactional
public class WorkStatusServiceImpl implements WorkStatusService {
	
	@Autowired
	private TasksRepo tasksRepo;
	
	@Autowired
	private TeamMemberRepo teamMemberRepo;

	@Override
	public List<TasksEntity> getTask() {
		
		return tasksRepo.findAll();
	}

	@Override
	public List<TeamMemberEntity> getAllTeamMember() {
		
		return teamMemberRepo.findAll();
	}

	@Override
	public TasksEntity updateWorkStatus(Integer taskId, String workStatus) {
		TasksEntity tasksEntity = tasksRepo.findById(taskId).get();
		tasksEntity.setWorkStatus(workStatus);
		return tasksRepo.save(tasksEntity);
	}

	@Override
	public TasksEntity updateTaskStatus(Integer taskId, String taskStatus) {
		TasksEntity tasksEntity = tasksRepo.findById(taskId).get();
		tasksEntity.setTaskStatus(taskStatus);
		return tasksRepo.save(tasksEntity);
	}

}
