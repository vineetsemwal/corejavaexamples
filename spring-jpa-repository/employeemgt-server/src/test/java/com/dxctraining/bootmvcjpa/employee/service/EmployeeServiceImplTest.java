package com.dxctraining.bootmvcjpa.employee.service;

import static org.junit.jupiter.api.Assertions.*;

import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import com.dxctraining.bootmvcjpa.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.bootmvcjpa.employee.dao.*;
import com.dxctraining.bootmvcjpa.exceptions.EmployeeNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({EmployeeServiceImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeServiceImplTest {

	@Autowired
	IEmployeeService service;
	
	@Autowired
	EntityManager entityManager;

	/**
	 * case: null argument passed in save
	 * verifying: InvalidArgumentException is thrown
	 */
	@Test
	public void testAdd_1() {
		Executable execute=()->service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, execute);
	}

	/**
	 * case: employee is added
	 * verifying: fetch stored employee detals and compare with expected details
	 */
	@Test
	public void testAdd_2(){
		String firstName="dharma",lastName="teja";
		Employee employee=new Employee(firstName,lastName);
		employee=service.save(employee);

		TypedQuery<Employee> query=entityManager.createQuery("from Employee",Employee.class);
		List<Employee>list=query.getResultList();
		Assertions.assertEquals(1,list.size());
	    Employee fetched=list.get(0);
	    Assertions.assertEquals(employee.getId(),fetched.getId());
	    Assertions.assertEquals(firstName,fetched.getFirstName());
	    Assertions.assertEquals(lastName, fetched.getLastName());

	}

}
