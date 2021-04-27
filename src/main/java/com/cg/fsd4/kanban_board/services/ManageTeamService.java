package com.cg.fsd4.kanban_board.services;

import java.util.List;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.entity.UserEntity;




public interface ManageTeamService {
	
	
	public UserEntity createUserAccount(UserEntity userEntity);

	public TeamLeadEntity addTeamLead(TeamLeadEntity teamLeadEntity);

	public TeamMemberEntity addTeamMember(TeamMemberEntity teamMemberEntity);

	public List<TeamMemberEntity> getTeamMembers();
	
	public List<TeamLeadEntity> getTeamLead();

	public ProjectEntity addProject(ProjectEntity teamLeaderId);

	public TeamLeadEntity deleteTeamLead(Integer teamLeaderId);

	public boolean deleteLead(TeamLeadEntity teamLead);

	public TeamMemberEntity deleteTeamMember(Integer teamMemberId);
	
	public boolean deleteMember(TeamMemberEntity teamLead);

	
}
