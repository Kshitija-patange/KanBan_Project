package com.cg.fsd4.kanban_board.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.exception.TeamLeadNotFoundException;
import com.cg.fsd4.kanban_board.repo.TeamMemberRepo;
import com.cg.fsd4.kanban_board.repo.ProjectRepo;
import com.cg.fsd4.kanban_board.repo.TeamLeadRepo;

@Service
@Transactional
public class TeamLeadServiceImpl implements TeamLeadService {

	@Autowired
	private TeamLeadRepo TeamLeadRepo;

	@Autowired
	private ProjectRepo ProjectRepo;

	@Autowired
	private TeamMemberRepo teamMemberRepo;

	/*
	 * Method to view the team lead list
	 */
	@Override
	public List<TeamLeadEntity> viewTeamLead() throws TeamLeadNotFoundException {

		try {
			List<TeamLeadEntity> teamLeadList = TeamLeadRepo.findAll();
			if (teamLeadList.size() != 0) {
				return teamLeadList;
			}
			return null;
		} catch (Exception e) {
			throw new TeamLeadNotFoundException(e.getMessage(), e);
		}
	}

	/*
	 * Method for login teamlead
	 */
	@Override
	public TeamLeadEntity Login(int teamLeadId, String projectPassword) throws EntityNotFoundException {
		String Login = "";
		TeamLeadEntity mObj = TeamLeadRepo.findById(teamLeadId).get();
		if (mObj.getProjectPassword().equals(projectPassword)) {
			// Login = "Logged in sucessfully as Leader!";
			return mObj;
		}
		throw new EntityNotFoundException("incorrect password!");
	}

	/*
	 * Method to update the status
	 */
	@Override
	public ProjectEntity UpdateStatus(String status, int projectId) throws TeamLeadNotFoundException {
		try {
			ProjectEntity projectentity = ProjectRepo.findById(projectId).get();
			projectentity.setProjectStatus(status);

			ProjectEntity project = ProjectRepo.save(projectentity);

			return project;
		}

		catch (Exception e) {
			throw new TeamLeadNotFoundException(e.getMessage(), e);
		}
	}

	/*
	 * Method to get Team member of that team
	 */
	@Override
	public List<TeamMemberEntity> getTeamMembers() throws TeamLeadNotFoundException {

		try {
			return teamMemberRepo.findAll();
		} catch (Exception e) {
			throw new TeamLeadNotFoundException(e.getMessage(), e);
		}
	}

	/*
	 * View the project details of that team lead // Testcase done
	 */
	@Override
	public TeamLeadEntity viewTeamLeadById(int teamLeadId) throws TeamLeadNotFoundException {

		try {
			TeamLeadEntity teamLeadEntity = null;
			Optional<TeamLeadEntity> teamlead = TeamLeadRepo.findById(teamLeadId);
			if (teamlead.isPresent()) {
				teamLeadEntity = teamlead.get();

			}
			return teamLeadEntity;
		} catch (Exception e) {
			throw new TeamLeadNotFoundException(e.getMessage(), e);
		}

	}

	@Override
	public List<TeamLeadEntity> getAllTeamLead() {

		return TeamLeadRepo.findAll();
	}

}
