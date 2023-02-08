package com.example.employeeManagement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.employeeManagement.exception.UserNotFoundException;
import com.example.employeeManagement.model.Employee;
import com.example.employeeManagement.repository.EmployeeRepository;

public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found"));
	}

	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}
}
