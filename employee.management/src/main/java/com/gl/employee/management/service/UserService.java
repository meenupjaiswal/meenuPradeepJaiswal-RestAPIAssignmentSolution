package com.gl.employee.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.employee.management.model.User;

@Service
public interface UserService {

	User createUser(User user);

	User updateUser(User user);

	List<User> viewUsers();

	void deleteUser(int id);

}
