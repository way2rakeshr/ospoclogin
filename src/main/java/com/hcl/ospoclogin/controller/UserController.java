package com.hcl.ospoclogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ospoclogin.dto.UserResponse;
import com.hcl.ospoclogin.entity.User;
import com.hcl.ospoclogin.exception.UserException;
import com.hcl.ospoclogin.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserResponse> authentication(@RequestBody User user) throws UserException {
		UserResponse authentication = userService.authentication(user);

		return new ResponseEntity<>(authentication, HttpStatus.CREATED);

	}

}
