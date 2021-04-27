package com.cg.fsd4.kanban_board.services;


import com.cg.fsd4.kanban_board.entity.TasksEntity;
import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;
import com.cg.fsd4.kanban_board.exception.TaskNotFoundException;
import com.cg.fsd4.kanban_board.repo.TasksRepo;
import com.cg.fsd4.kanban_board.repo.TeamMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageTasksServiceImpl implements  ManageTasksService{
    @Autowired
    private TasksRepo taskRepo;
    @Autowired
    private TeamMemberRepo TMRepo;
    public List<TasksEntity> listTasks(){
        List<TasksEntity> taskList = taskRepo.findAll();
        return taskList;
    }
    public TasksEntity findTask(int id){
        TasksEntity task = taskRepo.findById(id);
        return task;
    }
    public List<TasksEntity> addTask(TasksEntity taskObject, int fkey){
        TeamMemberEntity tmEntity= TMRepo.findById(fkey);
        TasksEntity newTask = taskRepo.save(new TasksEntity(taskObject.getTaskId(), taskObject.getTaskName(), taskObject.getTaskStatus(), taskObject.getWorkStatus(), tmEntity));
        List<TasksEntity> taskList = listTasks();
        return taskList;
    }
    public List<TasksEntity> deleteTask(int id) throws TaskNotFoundException {
        TasksEntity task = taskRepo.findById(id);
        if(task==null) {
            throw new TaskNotFoundException("Invalid Movie Id");
        }
        taskRepo.deleteById(task.getTaskId());
        List<TasksEntity> taskList = listTasks();
        return taskList;
    }
    public TasksEntity updateTask(int fkey, TasksEntity task) throws TaskNotFoundException {
        TasksEntity editableTask = taskRepo.findById(task.getTaskId());
        if(editableTask==null){
            throw new TaskNotFoundException("Invalid Task Id");
        }
        TeamMemberEntity tmEntity= TMRepo.findById(fkey);
        TasksEntity newTask = taskRepo.save(new TasksEntity(task.getTaskId(), task.getTaskName(), task.getTaskStatus(), task.getWorkStatus(), tmEntity));
        return newTask;
    }
}