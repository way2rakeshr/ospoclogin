package com.hcl.ospoclogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ospoclogin.dto.UserResponse;
import com.hcl.ospoclogin.entity.User;
import com.hcl.ospoclogin.exception.UserException;
import com.hcl.ospoclogin.exception.UserPassword;
import com.hcl.ospoclogin.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
	@Autowired

	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<UserResponse> authentication(@RequestBody User user) throws UserException, UserPassword {
	

		return new ResponseEntity<>(userService.authentication(user), HttpStatus.OK);

	}

}
