package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.services.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/rest/employee")
	public ResponseEntity createEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity(employee, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/rest/employeeDelete/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {
		if (employeeService.getEmployeeById(id) == null ) {
			return new ResponseEntity("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}else{
		employeeService.deleteEmployee(id);
		return new ResponseEntity(id, HttpStatus.OK);
		}

	}

}
