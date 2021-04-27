package com.cg.fsd4.kanban_board.services;

import com.cg.fsd4.kanban_board.entity.Login;
import com.cg.fsd4.kanban_board.entity.UserEntity;

public interface LoginService {
	

	public UserEntity signIn(Login user);
}
