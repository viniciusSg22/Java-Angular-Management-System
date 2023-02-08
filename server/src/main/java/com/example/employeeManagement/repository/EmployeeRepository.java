package com.example.employeeManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeManagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);
}
