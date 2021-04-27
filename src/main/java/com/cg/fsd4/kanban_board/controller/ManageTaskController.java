package com.cg.fsd4.kanban_board.controller;



import com.cg.fsd4.kanban_board.entity.TasksEntity;
import com.cg.fsd4.kanban_board.exception.TaskNotFoundException;
import com.cg.fsd4.kanban_board.exception.TeamMemberNotFoundException;
import com.cg.fsd4.kanban_board.services.ManageTasksService;
import com.cg.fsd4.kanban_board.services.ManageTasksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/kanban")
public class ManageTaskController {
    @Autowired
    public ManageTasksService TaskService = new ManageTasksServiceImpl();

    //FETCH ALL TASKS
    @GetMapping(value ="/tasks/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TasksEntity> fetchAllMovies() {
        return TaskService.listTasks();
    }
    @PostMapping(value="/tasks/{id}",produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TasksEntity> addaMovie(@RequestBody TasksEntity task, @PathVariable ("id") int fkey) throws TeamMemberNotFoundException {
        return  TaskService.addTask(task, fkey);
    }
    @DeleteMapping(value="/tasks/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<TasksEntity> deleteMovie(@PathVariable ("id") int id) throws TaskNotFoundException {
        return TaskService.deleteTask(id);
    }
    @PutMapping(value="/tasks/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public TasksEntity updateMovie(@PathVariable ("id") int id, @RequestBody TasksEntity task) throws TaskNotFoundException {
        return TaskService.updateTask(id, task);
    }
}
