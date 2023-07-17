package com.spring.service;

import org.springframework.data.domain.Page;

import com.spring.model.User;

public interface UserService {

	void addUser(User user);

	Page<User> fetchAllUsers(Integer offset, Integer pageSize);

}
