package com.dxctraining.bootmvcjpa.employee.service;

import static org.junit.jupiter.api.Assertions.*;

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

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({EmployeeServiceImpl.class,EmployeeDaoImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeServiceImplTest {

	@Autowired
	IEmployeeService service;
	
	@Autowired
	IEmployeeDao dao;
	
	@Test
	public void testAdd_1() {
		Executable execute=()->service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, execute);
	}

}
