package com.hcl.ospoclogin.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.ospoclogin.dto.UserResponse;
import com.hcl.ospoclogin.entity.User;
import com.hcl.ospoclogin.exception.UserException;
import com.hcl.ospoclogin.exception.UserPassword;
@FunctionalInterface
public interface UserService {
	UserResponse authentication( User user) throws UserException,UserPassword ;

}
