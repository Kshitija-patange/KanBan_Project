package com.cg.fsd4.kanban_board.services;



import java.util.List;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;



public interface UserService {
	
	public ProjectEntity addProject(ProjectEntity projectEntity);
	public List<ProjectEntity> getProjectDetails();
	public ProjectEntity deleteProject(Integer projectId);
	//public List<ProjectEntity> getAllProject();
	
	

	
}
