package com.gl.employee.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employee.management.model.Employee;
import com.gl.employee.management.service.EmployeeService;

@RestController
@RequestMapping("/gl/employee/management/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/save")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/list/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/list/name/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}

	@GetMapping("/list/sort")
	public List<Employee> getAllEmployeesSorted(@RequestParam String order) {
		if (order.equals("asc")) {
			return employeeService.sortByAscending();
		} else if (order.equals("dsc")) {
			return employeeService.sortByDescending();
		}
		return null;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "Delete Employee By ID: " + id;
	}

}
