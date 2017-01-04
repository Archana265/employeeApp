package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;

@RestController
public class EmployeeRestController {
	
	
	@PostMapping(value = "/rest/employee")
	public ResponseEntity createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity(employee, HttpStatus.CREATED);
	}

}
