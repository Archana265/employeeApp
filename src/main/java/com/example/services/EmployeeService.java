package com.example.services;

import com.example.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	public void deleteEmployee(long id);
}
