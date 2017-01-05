package com.example.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.services.EmployeeService;

@RestController
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
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        System.out.println("Fetching Employee with id " + id);
        Employee employee = employeeServiceImpl.getEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
 
	@RequestMapping(value = "/employee/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllUsers() {
        List<Employee> employee = employeeServiceImpl.findAllEmployees();
        if(employee.isEmpty()){
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        System.out.println("Updating Employee " + id);
         
        Employee currentEmployee = employeeServiceImpl.getEmployeeById(id);
         
        if (currentEmployee==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
 
        currentEmployee.setName(employee.getName());
         
        employeeServiceImpl.updateUser(currentEmployee);
        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }

}

	