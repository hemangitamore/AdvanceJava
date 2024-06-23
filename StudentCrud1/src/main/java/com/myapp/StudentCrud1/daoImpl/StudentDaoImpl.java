package com.myapp.StudentCrud1.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.myapp.StudentCrud1.dao.StudentDao;
import com.myapp.StudentCrud1.model.Student;


public class StudentDaoImpl implements StudentDao {
     
	private SessionFactory sessionFactory;
	private Session session;
	private Configuration configuration;
	
	public StudentDaoImpl() {
		configuration=new Configuration();
		configuration.configure().addAnnotatedClass(Student.class);
		sessionFactory=configuration.buildSessionFactory();
	}
	@Override
	public int save(Student student) {
		session=sessionFactory.openSession();
		Transaction transaction=null;
		Integer id= null;
		try {
			transaction=session.beginTransaction();
			id=(Integer) session.save(student);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return id;
	}

	@Override
	public List<Student> getAll() {
		session=sessionFactory.openSession();
		Transaction transaction=null;
		List<Student>studentList=new ArrayList<>();
		try {
			transaction=session.beginTransaction();
			studentList=session.createQuery("from Student").list();
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		return studentList;
	}

	@Override
	public Student getById(int id) {
		session=sessionFactory.openSession();
		Transaction transaction=null;
		Student student=null;
		try {
			transaction=session.beginTransaction();
			student=session.get(Student.class, id);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return student;
	}

	@Override
	public int remove(int id) {
		session=sessionFactory.openSession();
		Transaction transaction=null;
		int result=-1;
		try {
			transaction=session.beginTransaction();
			Student student=session.get(Student.class, id);
			if( student!=null) {
				session.delete(student);
				transaction.commit();
				result=1;
				
			}
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		}
		return result;
	}

	@Override
	public int update(int id, String name,float marks) {
		session = sessionFactory.openSession();
		Transaction transaction = null;
		int result = -1;
		try {
			transaction = session.beginTransaction();
			Student student = session.get(Student.class,id);
			if(student !=null) {
				student.setName(name);
				student.setMarks(marks);
				
				session.update(student );
				transaction.commit();
				result = 1;
			}
			
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

}
