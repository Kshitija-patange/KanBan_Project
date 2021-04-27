package com.cg.fsd4.kanban_board.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fsd4.kanban_board.entity.Login;
import com.cg.fsd4.kanban_board.entity.UserEntity;
import com.cg.fsd4.kanban_board.repo.LoginDao;

@Service

public class LoginServiceImpl implements LoginService {


	@Autowired
	private LoginDao loginRepository;

	@Override
	public UserEntity signIn(Login user) {
		// TODO Auto-generated method stub

		// str=null;
		UserEntity userObj = loginRepository.findByEmail(user.getEmail());
		if (userObj == null) {

		} else {
			String pwd = userObj.getPassword();

			if (pwd.equals(user.getPassword())) {

				return userObj;

			}
		}
		return null;

	}
}