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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@HystrixCommand(groupKey = "notification-service", fallbackMethod = "fallbackforcreateEmployee")
	@PostMapping(value = "/rest/employee")
	public ResponseEntity createEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity(employee, HttpStatus.CREATED);
	}
	
	@HystrixCommand(groupKey = "notification-service", fallbackMethod = "fallbackfordeleteEmployee")
	@DeleteMapping("/rest/employeeDelete/{id}")
	public ResponseEntity deleteEmployee(@PathVariable Long id) {
		if (employeeService.getEmployeeById(id) == null ) {
			return new ResponseEntity("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}else{
		employeeService.deleteEmployee(id);
		return new ResponseEntity(id, HttpStatus.OK);
		}
	}
	public ResponseEntity fallbackfordeleteEmployee(@PathVariable Long id){
		return new ResponseEntity("from fall back of fallbackfordeleteEmployee", HttpStatus.OK);
	}
	
	public ResponseEntity fallbackforcreateEmployee(@RequestBody Employee employee){
		return new ResponseEntity("from fall back of fallbackfordeleteEmployee", HttpStatus.OK);
	}

}
