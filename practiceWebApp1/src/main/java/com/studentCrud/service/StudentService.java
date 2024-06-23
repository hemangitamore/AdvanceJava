package com.studentCrud.service;

import java.util.List;

import com.studentCrud.model.Student;

public interface StudentService {
	int save(Student student);
	List<Student>getAll();
	Student getById(int id);
	int update(int id,Student student);
	int remove(int id);
	

}
