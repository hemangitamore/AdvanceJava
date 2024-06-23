package com.myapp.StudentCrud1.dao;

import java.util.List;

import com.myapp.StudentCrud1.model.Student;

public interface StudentDao {
	int save (Student student);
	List<Student>getAll();
	Student getById(int id);
	int remove(int id);
	int update(int id,String name,float marks);

}
