package com.dxctraining.service;


import com.dxctraining.dao.StudentStore;
import com.dxctraining.entities.*;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.exceptions.StudentNotFoundException;

import  org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.*;

import java.util.*;

class StudentServiceImplTest {

	StudentServiceImpl service;
	
	@BeforeEach
	void init() {
	service=new StudentServiceImpl();	
	}
	
	@AfterEach
	public void clear() {
	 Map<Integer,Student>store= StudentStore.getStore();
	 store.clear();
	}
		
	
	/**
	 * verifying student is stored in the store as expected
	 * 
	 * input: student object
	 */
	@Test
	public void testAdd_1() {
		Course linux = new Course(1, "linux");
		String studentName="dharma";
		int age=21;
		Student student = new ComputerScienceStudent(studentName, age, true, "dell", linux);
		service.add(student);
		int storedId=student.getId();
		Map<Integer,Student>store=StudentStore.getStore();
		Collection<Student>values=store.values();
		int actualSize=values.size();
		Assertions.assertEquals(1, actualSize);
		Iterator<Student>iterator=values.iterator();
		Student storedStudent=iterator.next();
		int actualAge=storedStudent.getAge();
		Course actualCourse=storedStudent.getCourse();
		Assertions.assertEquals(storedStudent.getId(), storedId);
		Assertions.assertEquals(age, actualAge);
		Assertions.assertEquals(studentName,storedStudent.getName());
		Assertions.assertEquals(linux.getId(),actualCourse.getId());
		
	}
	
	/**
	 * verifying InvalidArgumentException is thrown when student is null in add method
	 * input: null
	 */
	@Test
	public void testAdd_2() {
		/*
		Executable executable=new Executable() {

			@Override
			public void execute() throws Throwable {
				service.add(null);						
			}
			
		};
		*/
		
		Executable executable=()->service.add(null);	
        Assertions.assertThrows(InvalidArgumentException.class, executable)	;	
	}
	
	/**
	 * precondition: student which is fetched is there in the store so we will add in the store first
	 * verifying student is fetched correctly
	 * 
	 * input : id=100 
	 */
	@Test
	public void testFindById_1() {
	Map<Integer,Student>store=StudentStore.getStore();	
	Course linux = new Course(1, "linux");
	String studentName="dharma";
	int age=21;
    int id=100;    
	Student student = new ComputerScienceStudent(studentName, age, true, "dell", linux);
	student.setId(id);
	//
	//added student in the store for precondition 
	//
	store.put(id,student);
	
	Student actual=service.findById(id);
	Assertions.assertNotNull(actual);
	Assertions.assertEquals(id, actual.getId());
	Assertions.assertEquals(studentName, actual.getName());
	Course actualCourse=actual.getCourse();
	Assertions.assertEquals(linux.getId(),actualCourse.getId());
	Assertions.assertEquals(linux.getName(),actualCourse.getName());
	}
	
	
   /**
    * precondition : id doesn't exist 
    * verifying StudentNotFoundException is thrown because there is no student with id 153 in the store
    */
	@Test
	public void testFindById_2() {
	int id=153;	
	Executable executable=()->service.findById(id);
	Assertions.assertThrows(StudentNotFoundException.class,executable);
	
	}
	
}
