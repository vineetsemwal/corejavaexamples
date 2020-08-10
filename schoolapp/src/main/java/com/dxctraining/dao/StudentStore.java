package com.dxctraining.dao;

import java.util.*;

import com.dxctraining.entities.Student;

public class StudentStore {

	private static Map<Integer, Student> store = new HashMap<>();

	public static Map<Integer,Student> getStore() {
		return store;
	}
	
	
}
