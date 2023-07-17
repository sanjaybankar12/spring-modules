package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	public Page<User> fetchAllUsers(Integer offset, Integer pageSize) {
		return this.userRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.ASC, "id")));
	}
}
