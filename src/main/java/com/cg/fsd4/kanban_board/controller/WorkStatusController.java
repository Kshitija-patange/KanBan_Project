package com.cg.fsd4.kanban_board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fsd4.kanban_board.entity.TasksEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.response.KanbanBoardResponse;
import com.cg.fsd4.kanban_board.services.WorkStatusService;

@RequestMapping(path = "/api/kanban_board")
@RestController
public class WorkStatusController {

	@Autowired
	private WorkStatusService workStatusService;

	@GetMapping(path = "/getTask/{teamMemberId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public KanbanBoardResponse getTask(@PathVariable Integer teamMemberId) {
		List<TasksEntity> teamMember = workStatusService.getTask();
		List<TasksEntity> tasks = new ArrayList<TasksEntity>();
		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();

		for (TasksEntity onebyone : teamMember) {
			if (onebyone.getTeamMemberEntity().getTeamMemberId() == teamMemberId) {
				tasks.add(onebyone);
			}
		}
		kanbanBoardResponse.setTasks(tasks);
		return kanbanBoardResponse;
	}

	@GetMapping(path = "/teamMemberLogin/{employeeId}/{projectPassword}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public KanbanBoardResponse teamMemberLogin(@PathVariable Long employeeId, @PathVariable String projectPassword) {
		List<TeamMemberEntity> teamMember = workStatusService.getAllTeamMember();
		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();

		int count = 0;
		try {
		for (TeamMemberEntity onebyone : teamMember) {
			if (onebyone.getEmployeeId() == employeeId && onebyone.getProjectPassword().equals(projectPassword)) {
				kanbanBoardResponse.setMessage("logged successfull");
				kanbanBoardResponse.setTeamMemberEntity(onebyone);
				count++;
			}
		}
		}catch(Exception e) {
			kanbanBoardResponse.setMessage("login failed");
			return kanbanBoardResponse;
		}
		if (count == 0) {
			kanbanBoardResponse.setMessage("login failed");
		}
		return kanbanBoardResponse;
	}

	@PutMapping("/updateWorkStatus/{workStatus:.+}/TasksEntity/{taskId}")
	public TasksEntity updateWorkStatus(@PathVariable Integer taskId, @PathVariable String workStatus) {
		return workStatusService.updateWorkStatus(taskId, workStatus);
	}

	@PutMapping("/updateTaskStatus/{taskStatus:.+}/TasksEntity/{taskId}")
	public TasksEntity updateTaskStatus(@PathVariable Integer taskId, @PathVariable String taskStatus) {
		return workStatusService.updateTaskStatus(taskId, taskStatus);
	}

}
