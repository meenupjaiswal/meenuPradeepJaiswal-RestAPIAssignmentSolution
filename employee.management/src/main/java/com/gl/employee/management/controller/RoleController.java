package com.gl.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employee.management.model.Role;
import com.gl.employee.management.service.RoleService;

@RestController
@RequestMapping("/gl/employee/management/role")
public class RoleController {
	
	@Autowired
	RoleService roleServiceImpl;
	
	@PostMapping("/save")
	public Role createRole(@RequestBody Role role) {
		if(role.getId()!=0) {
			return roleServiceImpl.updateRole(role);
		}
		return roleServiceImpl.createRole(role);
	}
	
	@GetMapping("/list")
	public List<Role> getAllRoles(){
		return roleServiceImpl.viewRoles();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteRole(@PathVariable int id) {
		roleServiceImpl.deleteRole(id);
	}

}
