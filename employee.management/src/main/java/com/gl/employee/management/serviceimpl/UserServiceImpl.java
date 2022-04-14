package com.gl.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employee.management.model.User;
import com.gl.employee.management.repository.UserRepository;
import com.gl.employee.management.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.getById(user.getId());
		if (existingUser != null) {
			existingUser.setUserName(user.getUserName());
			existingUser.setPassword(user.getPassword());
			existingUser.setRoles(user.getRoles());
			userRepository.save(existingUser);
		}
		return null;
	}

	@Override
	public List<User> viewUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
