package com.cg.fsd4.kanban_board.services;

import java.util.List;


import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.exception.TeamLeadNotFoundException;


public interface TeamLeadService {
	
	
	public List<TeamLeadEntity> viewTeamLead()  throws TeamLeadNotFoundException;
	
	public TeamLeadEntity viewTeamLeadById(int teamLeadId)  throws TeamLeadNotFoundException;
	
	public TeamLeadEntity Login( int teamLeadId, String projectPassword)  throws TeamLeadNotFoundException;
	
	public ProjectEntity UpdateStatus(String status,int projectId)  throws TeamLeadNotFoundException;
	
	public List<TeamMemberEntity> getTeamMembers()  throws TeamLeadNotFoundException;
	
	public List<TeamLeadEntity> getAllTeamLead();
}
