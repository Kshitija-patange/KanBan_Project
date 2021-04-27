package com.cg.fsd4.kanban_board.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.entity.UserEntity;
import com.cg.fsd4.kanban_board.repo.ProjectRepo;
import com.cg.fsd4.kanban_board.repo.TeamLeadRepo;
import com.cg.fsd4.kanban_board.repo.TeamMemberRepo;
import com.cg.fsd4.kanban_board.repo.UserRepo;

@Service
@Transactional
public class TeamMemberServiceImpl implements TeamMemberService {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TeamLeadRepo teamLeadRepo;
	
	@Autowired
	private TeamMemberRepo teamMemberRepo;

	@Override
	public ProjectEntity getProjectDetails(Integer projectId) {
		
		return projectRepo.findById(projectId).get();
	}
	
	@Override
	public List<ProjectEntity> getUser() {
		
		return projectRepo.findAll();
	}

	@Override
	public List<TeamLeadEntity> getTeamLead() {

		return teamLeadRepo.findAll();
	}

	@Override
	public List<TeamMemberEntity> getTeamMembers() {

		return teamMemberRepo.findAll();
	}

}
