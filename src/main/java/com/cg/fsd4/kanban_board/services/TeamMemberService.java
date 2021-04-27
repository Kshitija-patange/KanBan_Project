package com.cg.fsd4.kanban_board.services;

import java.util.List;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.entity.UserEntity;

public interface TeamMemberService {
	
	public ProjectEntity getProjectDetails(Integer projectId);
	
	public List<ProjectEntity> getUser();
	
	public List<TeamLeadEntity> getTeamLead();
	
	public List<TeamMemberEntity> getTeamMembers();
}
