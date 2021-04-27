package com.cg.fsd4.kanban_board.services;

import com.cg.fsd4.kanban_board.entity.TasksEntity;
import com.cg.fsd4.kanban_board.exception.TaskNotFoundException;
import com.cg.fsd4.kanban_board.exception.TeamMemberNotFoundException;

import java.util.List;

public interface ManageTasksService {
    public List<TasksEntity> listTasks();
    public TasksEntity updateTask(int id, TasksEntity task) throws TaskNotFoundException;
    public List<TasksEntity> addTask(TasksEntity taskObject, int fkey) throws TeamMemberNotFoundException;
    public List<TasksEntity> deleteTask(int fkey) throws TaskNotFoundException;
    public TasksEntity findTask(int id) throws TaskNotFoundException;
}
