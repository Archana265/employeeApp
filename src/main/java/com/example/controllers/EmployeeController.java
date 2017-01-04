package com.example.controllers;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Employee;
import com.example.services.EmployeeService;

@Controller
public class EmployeeController {
	static Logger logger = Logger.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeService employeeServiceImpl;
	@RequestMapping(value = "employee", method = RequestMethod.GET)
	public String saveEmployee(Employee employee){
		logger.info("from EmployeeController.class saveEmployee(Employee employee)");
		employeeServiceImpl.saveEmployee(employee);
		return "redirect:/employee" ;
		
	}
	
	

}
