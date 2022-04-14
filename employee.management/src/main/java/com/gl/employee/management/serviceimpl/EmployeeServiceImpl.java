package com.gl.employee.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.employee.management.model.Employee;
import com.gl.employee.management.repository.EmployeeRepository;
import com.gl.employee.management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = getEmployeeById(employee.getId());
		if (existingEmployee != null) {
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
			return employeeRepository.save(existingEmployee);
		}
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return employeeRepository.findByFirstName(name);
	}

	@Override
	public List<Employee> sortByAscending() {
		return employeeRepository.findByOrderByFirstName();
	}

	@Override
	public List<Employee> sortByDescending() {
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
	}

}
