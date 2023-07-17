package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.User;
import com.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addUser(@RequestBody @Valid User user) {
		this.userService.addUser(user);
	}
	
	@GetMapping
	public Page<User> getUsers(@RequestParam Integer offset, @RequestParam("pagesize") Integer pageSize) {
		return this.userService.fetchAllUsers(offset, pageSize);
	}
}
