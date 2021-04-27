package com.cg.fsd4.kanban_board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fsd4.kanban_board.entity.ProjectEntity;
import com.cg.fsd4.kanban_board.entity.UserEntity;
import com.cg.fsd4.kanban_board.exception.ResourceNotFoundException;
import com.cg.fsd4.kanban_board.repo.ProjectRepo;
import com.cg.fsd4.kanban_board.repo.UserRepo;
import com.cg.fsd4.kanban_board.response.KanbanBoardResponse;
import com.cg.fsd4.kanban_board.services.UserService;

@RestController
@RequestMapping("/api/kanban_board")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private ProjectRepo projectRepo;

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<UserEntity> getAllUser() {
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public void createUser(@RequestBody UserEntity user) {
		userRepository.save(user);

	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable int id) throws ResourceNotFoundException {
		UserEntity user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found"));
		return ResponseEntity.ok(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable int id, @RequestBody UserEntity userDetails)
			throws ResourceNotFoundException {
		UserEntity user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found"));
		user.setUserName(userDetails.getUserName());
		user.setEmailId(userDetails.getEmailId());

		user.setPassword(userDetails.getPassword());

		user.setOrganisation(userDetails.getOrganisation());

		UserEntity updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) throws ResourceNotFoundException {
		UserEntity user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found"));
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PostMapping(path = "/addProjectByUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addProject(@RequestBody ProjectEntity projectEntity) {

		ProjectEntity project = userService.addProject(projectEntity);
		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();

		if (project == null) {

			kanbanBoardResponse.setMessage("Project not added");
		} else {

			kanbanBoardResponse.setMessage("Project added succesfully");
		}
	}

//			return kanbanBoardResponse;
//		}

	@GetMapping(path = "/getprojectdetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public KanbanBoardResponse getProjectDetails(Integer userId) {

		List<ProjectEntity> project = userService.getProjectDetails();
		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
		for (ProjectEntity onebyone : project) {
			if (onebyone.getUserEntity().getUserId() == userId) {
				list.add(onebyone);
			}
		}

		kanbanBoardResponse.setProjectList(list);
		return kanbanBoardResponse;
	}

	@DeleteMapping(path = "/deletetproject", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public KanbanBoardResponse deleteProject(Integer projectId) {
		ProjectEntity teamLead = userService.deleteProject(projectId);
		KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();

		return kanbanBoardResponse;
	}
}
//
//		@DeleteMapping(path = "/deleteproject", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public KanbanBoardResponse deleteProject(Integer ProjectId) {
//			ProjectEntity teamLead = userService.deleteProject(ProjectId);
//			KanbanBoardResponse kanbanBoardResponse = new KanbanBoardResponse();
//			
//			return kanbanBoardResponse;
//		}
//
//	}
// ---------working-----//
//	@GetMapping("/project/{id}")
//	public ResponseEntity<ProjectEntity> getProjectById(@PathVariable int id) throws ResourceNotFoundException
//	{
//		ProjectEntity user=projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("project  not found"));
//		return ResponseEntity.ok(user);
//	}
//	@PostMapping("/project")
//	public void addProject(@RequestBody ProjectEntity user)
//	{
//		projectRepo.save(user);
//	
//	}
//	@DeleteMapping("/project/{id}")
//	public ResponseEntity<Map<String,Boolean>> deleteProject(@PathVariable int id) throws ResourceNotFoundException
//	{
//		ProjectEntity user=projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
//		projectRepo.delete(user);
//		Map<String,Boolean> response=new HashMap<>();
//		response.put("deleted",Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
//	
