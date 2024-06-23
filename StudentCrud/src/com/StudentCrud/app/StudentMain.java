package com.StudentCrud.app;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.StudentCrud.daoImpl.StudentDaoImpl;
import com.StudentCrud.model.Student;

public class StudentMain {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
	System.out.println("Enter student id:");
		int id=sc.nextInt();
		sc.nextLine();
	System.out.println("Enter student name :");
		String name=sc.nextLine();
	System.out.println("Enter student marks:");
	float marks=sc.nextFloat();
		
		
		Student student=new Student(id,name,marks);
		
        StudentDaoImpl s=new StudentDaoImpl();
//		int result=s.save(student);
//		System.out.println(result);
     //List<Student> rs=   s.getAll();
     //Student s1=   s.getById(1);
    //  int result= s.remove(1);
        
      int result=  s.update(2, student.setName("Brinda"),student.setMarks(90));
        
     System.out.println(result);
		
		
		
		
		
		
		
	}

}
