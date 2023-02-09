package com.example.employeeManagement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeManagement.exception.UserNotFoundException;
import com.example.employeeManagement.model.Employee;
import com.example.employeeManagement.repository.EmployeeRepository;

@Service
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

	public Employee updateEmployeeById(Long id, Employee employee) {
		Employee existingEmployee = findEmployeeById(id);
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setPhone(employee.getPhone());
		existingEmployee.setJobTitle(employee.getJobTitle());
		existingEmployee.setImageUrl(employee.getImageUrl());
		existingEmployee.setEmployeeCode(employee.getEmployeeCode());

		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found"));
	}

	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}
}
