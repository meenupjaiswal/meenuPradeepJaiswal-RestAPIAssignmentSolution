package com.gl.employee.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.employee.management.config.UserDetailsConfig;
import com.gl.employee.management.model.User;
import com.gl.employee.management.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not foud!");
		}
		UserDetailsConfig userConfig = new UserDetailsConfig(user);
		return userConfig;
	}

}
