package com.gl.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employee.management.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUserName(String name);

}
