package com.gl.employee.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.employee.management.model.Employee;

@Service
public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);

	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(int id);
	
	List<Employee> getEmployeeByName(String name);
	
	List<Employee> sortByAscending();
	
	List<Employee> sortByDescending();
}
