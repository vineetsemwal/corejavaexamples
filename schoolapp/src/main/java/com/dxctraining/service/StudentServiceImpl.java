package com.dxctraining.service;

import java.util.List;

import com.dxctraining.dao.*;
import com.dxctraining.entities.Student;
import com.dxctraining.exceptions.*;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao dao = new StudentDaoImpl();

	@Override
	public Student findById(int id) {
		checkId(id);
		Student student = dao.findById(id);
		return student;
	}



	@Override
	public List<Student> findAll() {
		List<Student>list=dao.findAll();
		return list;
	}

	
	
	public void checkId(int id) {
		if (id < 1) {
			throw new InvalidArgumentException("id cant be negative, id passed="+id);
		}
	}

	public void checkName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidArgumentException("name cant be null or empty");
		}
	}
	
	public void checkStudent(Student student) {
		if(student==null) {
			throw new InvalidArgumentException("student cant be null or empty");
				
		}
	}

	@Override
	public Student updateName(int id, String newName) {
		checkId(id);
		checkName(newName);
		Student student = dao.updateName(id, newName);
		return student;
	}

	@Override
	public Student update(Student student) {
		checkStudent(student);
		student =dao.update(student);
	    return student;
	}

	@Override
	public void add(Student student) {
		checkStudent(student);
		dao.add(student);
		
	}

	@Override
	public void delete(int id) {
	  checkId(id);	
	  dao.delete(id);		
	}


}
