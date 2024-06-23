package com.StudentCrud.dao;

import java.util.List;

import com.StudentCrud.model.Student;

public interface StudentDao {
	int save(Student student);
	List<Student>getAll();
	Student getById(int id);
	int remove(int id);
	int update(int id,Student student);
	
	

}
