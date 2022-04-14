package com.gl.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employee.management.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
