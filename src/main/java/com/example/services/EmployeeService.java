package com.example.services;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	List<Employee> findAllEmployees();
	void updateUser(Employee currentEmployee);
}
