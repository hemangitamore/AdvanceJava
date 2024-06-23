package com.studentCrud.serviceImpl;

import java.util.List;

import com.studentCrud.daoImpl.StudentDaoImpl;
import com.studentCrud.model.Student;
import com.studentCrud.service.StudentService;

public class StudentServiceImpl implements StudentService {
     StudentDaoImpl studentDaoImpl;
     public StudentServiceImpl() {
    	 studentDaoImpl=new StudentDaoImpl();
    	 
     }
	
	
	@Override
	public int save(Student student) {
		// TODO Auto-generated method stub
		return studentDaoImpl.save(student);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentDaoImpl.getAll();
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		
		return studentDaoImpl.getById(id);
	}

	@Override
	public int update(int id, Student student) {
		// TODO Auto-generated method stub
		return studentDaoImpl.update(id, student);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return studentDaoImpl.remove(id);
	}
	

}
