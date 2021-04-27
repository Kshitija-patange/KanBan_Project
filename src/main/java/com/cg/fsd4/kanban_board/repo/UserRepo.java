package com.cg.fsd4.kanban_board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fsd4.kanban_board.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{ 
	
}
