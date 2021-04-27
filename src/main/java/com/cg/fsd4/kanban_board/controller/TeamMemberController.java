package com.cg.fsd4.kanban_board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.TeamLeadEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.entity.UserEntity;
import com.cg.fsd4.kanban_board.response.KanbanBoardResponse;
import com.cg.fsd4.kanban_board.services.TeamMemberService;

@RequestMapping(path = "/api/kanban_board")
@RestController

public class TeamMemberController {

	@Autowired
	private TeamMemberService teamMemberService;

	@GetMapping(path = "/viewProjectDetails/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProjectEntity viewProjectDetails(@PathVariable Integer projectId) {
//		ProjectEntity projectEntity = teamMemberService.getProjectDetails(projectId);
//		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();
//		if(projectEntity == null) {
//			kanbanBoardResponse.setMessage("details found");
//			kanbanBoardResponse.setProjectEntity(projectEntity);
//		}else {
//			kanbanBoardResponse.setMessage("details not found");
//		}
		return teamMemberService.getProjectDetails(projectId);
	}

	@GetMapping(path = "/getUser/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public KanbanBoardResponse getUser(@PathVariable Integer projectId) {
		List<ProjectEntity> project = teamMemberService.getUser();
		UserEntity user;
		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();

		for (ProjectEntity onebyone : project) {
			if (onebyone.getProjectId() == projectId) {
				user = onebyone.getUserEntity();
				kanbanBoardResponse.setUserEntity(user);
				kanbanBoardResponse.setMessage("user details found");
				return kanbanBoardResponse;
			}
		}

		kanbanBoardResponse.setMessage("user details not found");
		return kanbanBoardResponse;
	}

	@GetMapping(path = "/getTeamLead/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public KanbanBoardResponse getTeamLead(@PathVariable Integer projectId) {
		List<TeamLeadEntity> teamLead = teamMemberService.getTeamLead();
		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();

		for (TeamLeadEntity onebyone : teamLead) {
			if (onebyone.getProjectEntity().getProjectId() == projectId) {
				kanbanBoardResponse.setTeamLeadEntity(onebyone);
				kanbanBoardResponse.setMessage("Team lead details found");
				return kanbanBoardResponse;
			}
		}
		kanbanBoardResponse.setMessage("No Team lead found");
		return kanbanBoardResponse;
	}

	@GetMapping(path = "/getTeamMembers/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public KanbanBoardResponse getTeamMembers(@PathVariable Integer projectId) {

		List<TeamMemberEntity> teamMembers = teamMemberService.getTeamMembers();
		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();
		List<TeamMemberEntity> list = new ArrayList<TeamMemberEntity>();
		for (TeamMemberEntity onebyone : teamMembers) {
			if (onebyone.getProjectEntity().getProjectId() == projectId) {
				list.add(onebyone);
			}
		}

		kanbanBoardResponse.setMembersList(list);
		return kanbanBoardResponse;
	}

}
