package com.dxctraining.dao;

import java.util.List;

import com.dxctraining.entities.Student;

public interface IStudentDao {
	Student findById(int id);

	List<Student> findAll() ;
	
	Student updateName(int id, String newName);

	void add(Student student);
	
	Student update(Student student);
	
	void delete(int id);
}
