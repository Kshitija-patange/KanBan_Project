package com.cg.fsd4.kanban_board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fsd4.kanban_board.entity.TeamMemberEntity;

@Repository

public interface TeamMemberRepo extends JpaRepository<TeamMemberEntity, Integer>{
    public TeamMemberEntity findById(int id);
}