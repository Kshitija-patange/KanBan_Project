package com.cg.fsd4.kanban_board.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.entity.UserEntity;
import com.cg.fsd4.kanban_board.exception.TeamMemberNotFoundException;
import com.cg.fsd4.kanban_board.repo.ProjectRepo;
import com.cg.fsd4.kanban_board.repo.TeamLeadRepo;
import com.cg.fsd4.kanban_board.repo.TeamMemberRepo;
import com.cg.fsd4.kanban_board.repo.UserRepo;

@Service
@Transactional
public class ManageTeamServiceImpl implements ManageTeamService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private TeamLeadRepo teamLeadRepo;

	@Autowired
	private TeamMemberRepo teamMemberRepo;

	@Autowired
	private ProjectRepo ProjectRepo;

	@Override
	public UserEntity createUserAccount(UserEntity userEntity) {

		return userRepo.save(userEntity);
	}

	@Override
	public TeamLeadEntity addTeamLead(TeamLeadEntity teamLeadEntity) {

		return teamLeadRepo.save(teamLeadEntity);
	}

	@Override
	public TeamMemberEntity addTeamMember(TeamMemberEntity teamMemberEntity) {

		return teamMemberRepo.save(teamMemberEntity);
	}

	@Override
	public List<TeamMemberEntity> getTeamMembers() {

		return teamMemberRepo.findAll();
	}

	@Override
	public List<TeamLeadEntity> getTeamLead() {

		return teamLeadRepo.findAll();
	}

	@Override
	public ProjectEntity addProject(ProjectEntity projectEntity) {
		return ProjectRepo.save(projectEntity);
	}

	@Override
	public TeamLeadEntity deleteTeamLead(Integer teamLeaderId) {

		return teamLeadRepo.findById(teamLeaderId).get();
	}

	@Override
	public boolean deleteLead(TeamLeadEntity teamLead) {
		teamLeadRepo.delete(teamLead);
		return true;
	}

	@Override
	public TeamMemberEntity deleteTeamMember(Integer teamMemberId) {

		return teamMemberRepo.findById(teamMemberId).get();

	}

	@Override
	public boolean deleteMember(TeamMemberEntity teamMember) {

		teamMemberRepo.delete(teamMember);
		return true;
	}
}
