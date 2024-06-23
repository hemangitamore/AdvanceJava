package com.studentCrud.dao;

import java.util.List;

import com.studentCrud.model.Student;

public interface StudentDao {
	int save(Student student);
	List<Student>getAll();
	int remove(int id);
	Student getById(int id);
	int update(int id,Student student);
	
	

}
