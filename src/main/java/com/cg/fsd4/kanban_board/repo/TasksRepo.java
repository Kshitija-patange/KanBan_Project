package com.cg.fsd4.kanban_board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cg.fsd4.kanban_board.entity.TasksEntity;

@Repository
public interface TasksRepo extends JpaRepository<TasksEntity, Integer>{
    public TasksEntity findById(int id);

    public void deleteById(int id);
}