package com.dxctraining.service;

import java.util.List;

import com.dxctraining.entities.Student;

public interface IStudentService {
	Student findById(int id);

	List<Student> findAll();

	Student updateName(int id, String newName);

	void add(Student student);

	Student update(Student student);

	void delete(int id);
}
