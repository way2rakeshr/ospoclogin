package com.hcl.ospoclogin.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ospoclogin.dto.UserResponse;
import com.hcl.ospoclogin.entity.User;
import com.hcl.ospoclogin.exception.UserException;
import com.hcl.ospoclogin.exception.UserPassword;
import com.hcl.ospoclogin.repository.UserRepository;
import com.hcl.ospoclogin.utlity.AppConstant;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponse authentication(User user) throws UserException, UserPassword {
		System.out.println("first");
		if (user.getUserName().isEmpty() || user.getPassword().isEmpty())
			throw new UserException(AppConstant.USERNAME_AND_PASSWORD);
		Optional<User> userName = userRepository.findByUserName(user.getUserName());

		if (!userName.isPresent())
			throw new UserException(AppConstant.USER_NOT_EXIST);

		if (userName.get().getUserName().equals(user.getUserName())
				&& userName.get().getPassword().equals(user.getPassword())) {
			return new UserResponse(AppConstant.SUCCESFULLY_LOGGED_IN_STATUS, AppConstant.SUCCESFULLY_LOGGED_IN);
		} else {
			throw new UserPassword(AppConstant.PASSWORD_NOT_MATCHING);
		}

	}
}
