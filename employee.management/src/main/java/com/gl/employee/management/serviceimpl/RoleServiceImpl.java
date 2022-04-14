package com.gl.employee.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employee.management.model.Role;
import com.gl.employee.management.repository.RoleRepository;
import com.gl.employee.management.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		Role existingRole = roleRepository.getById(role.getId());
		if (existingRole != null) {
			existingRole.setName(role.getName());
			roleRepository.save(existingRole);
		}
		return null;
	}

	@Override
	public List<Role> viewRoles() {
		return roleRepository.findAll();
	}

	@Override
	public void deleteRole(int id) {
		roleRepository.deleteById(id);
	}

}
