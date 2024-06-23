package com.StudentCrud.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.StudentCrud.dao.StudentDao;
import com.StudentCrud.model.Student;
import com.StudentCrud.util.sqlUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int save(Student student) {
		int result=-1;
		try {
			sqlUtil.connectDb();
			sqlUtil.stmt=sqlUtil.conn.prepareStatement("insert into studentInfo values(?,?,?)");
			sqlUtil.stmt.setInt(1, student.getId());
			sqlUtil.stmt.setString(2, student.getName());
			sqlUtil.stmt.setFloat(3, student.getMarks());
			result=sqlUtil.insert();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> getAll() {
		List<Student>s=new ArrayList<>();
		try {
			sqlUtil.connectDb();
			sqlUtil.stmt=sqlUtil.conn.prepareStatement("select *from studentInfo");
			ResultSet rs=sqlUtil.fetch();
			if(rs!=null) {
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					float marks=rs.getFloat("marks");
					Student student=new Student(id,name,marks);
					s.add(student);
				}
			}
			sqlUtil.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
		
	}

	@Override
	public Student getById(int id) {
		Student student=new Student();
		try {
			sqlUtil.connectDb();
			sqlUtil.stmt=sqlUtil.conn.prepareStatement("select * from studentInfo where id=?");
			sqlUtil.stmt.setInt(1,id);
		ResultSet rs=	sqlUtil.fetch();
		if(rs!=null) {
			while(rs.next()) {
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getFloat("marks"));
				
				
			}
		}
		sqlUtil.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public int remove(int id) {
		int result=-1;
		try {
			sqlUtil.connectDb();
			sqlUtil.stmt=sqlUtil.conn.prepareStatement("delete from studentInfo where id=?");
		sqlUtil.stmt.setInt(1,id);
		result=	sqlUtil.delete();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(int id, Student student) {
		// TODO Auto-generated method stub
		int result=-1;
		try {
			sqlUtil.connectDb();
			sqlUtil.stmt=sqlUtil.conn.prepareStatement("update studentInfo set name=?,marks=? where id=?");
			sqlUtil.stmt.setString(1,student.getName());
			sqlUtil.stmt.setFloat(2,student.getMarks());
			sqlUtil.stmt.setInt(3, student.getId());
		result=	sqlUtil.update();
		sqlUtil.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	

	 

}
