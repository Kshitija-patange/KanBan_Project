package com.cg.fsd4.kanban_board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.fsd4.kanban_board.entity.UserEntity;

@Repository
public interface LoginDao extends JpaRepository<UserEntity, Integer> {
	@Query("select rs from UserEntity rs where rs.emailId=?1")
	public UserEntity findByEmail(String email);
}
