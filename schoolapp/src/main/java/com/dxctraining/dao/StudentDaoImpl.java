package com.dxctraining.dao;

import com.dxctraining.entities.*;
import com.dxctraining.exceptions.StudentNotFoundException;

import java.util.*;

public class StudentDaoImpl implements IStudentDao {

	private Map<Integer, Student> store = StudentStore.getStore();

	private int generatedId;

	private int generateId() {
		generatedId++;
		return generatedId;
	}

	@Override
	public Student findById(int id) {
		Student student = store.get(id);
		if (student == null) {
			throw new StudentNotFoundException("student not found for id=" + id);
		}
		return student;
	}

	@Override
	public List<Student> findAll() {
		Collection<Student> values = store.values();
		List<Student> list = new ArrayList<>();
		for (Student value : values) {
			list.add(value);
		}
		return list;
	}

	@Override
	public void add(Student student) {
		int id = generateId();
		store.put(id, student);
		student.setId(id);
	}

	@Override
	public Student updateName(int id, String newName) {
		Student student = findById(id);
		student.setName(newName);
		return student;
	}

	@Override
	public Student update(Student student) {
		int id = student.getId();
		store.put(id, student);
		return student;
	}

	@Override
	public void delete(int id) {
		store.remove(id);
	}

}
