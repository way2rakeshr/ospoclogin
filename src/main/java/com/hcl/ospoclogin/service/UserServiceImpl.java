package com.hcl.ospoclogin.service;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ospoclogin.dto.UserResponse;
import com.hcl.ospoclogin.entity.User;
import com.hcl.ospoclogin.exception.UserException;
import com.hcl.ospoclogin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponse authentication(User user) throws UserException {
		Optional<User> userName = userRepository.findByUserName(user.getUserName());

		if (!userName.isPresent())
			throw new UserException("user not exist");

		if (userName.get().getUserName().equals( user.getUserName()) && userName.get().getPassword() .equals( user.getPassword())) {
			return new UserResponse(701, "succesfully logged in");
		} else {
			throw new UserException("password is not matching with username");
		}

	}
}
