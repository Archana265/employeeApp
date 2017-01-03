package com.example.repositories;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testSaveEmployee(){
		Employee employee = new Employee();
		employee.setId(1l);
		employee.setName("abc");
		
		employeeRepository.save(employee);
		Employee fetchEmployee =  employeeRepository.findOne(employee.getId());
		assertNotNull(fetchEmployee);
		
		
	}

}
