package com.myapp.StudentCrud1;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.myapp.StudentCrud1.daoImpl.StudentDaoImpl;
import com.myapp.StudentCrud1.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
        char continuationChoice;
        do {
        	System.out.println("1.Add student\n2. FGet all students\n3. Get bye id\n4. Remove student\n5. Exit");
        	System.out.println("Enter choice:");
        	int choice =sc.nextInt();
        	if(choice==1) {
        		Student student=new Student();
        		System.out.println("enter name");
        		sc.nextLine();
        		student.setName(sc.nextLine());
        		System.out.println("enter marks");
        		student.setMarks(sc.nextInt());
        		int id=studentDaoImpl.save(student);
        		System.out.println("entered id"+id);
        		
        	}else if(choice==2) {
        		List<Student>students=studentDaoImpl.getAll();
        		if(students.size()==0) {
        			System.out.println("No employee found !");
        		}else {
        			Iterator<Student>itr=students.iterator();
        			while(itr.hasNext()) {
        				Student student=itr.next();
        				System.out.println(student);
        			}
        		}
        	}
        	else if(choice==3) {
        		System.out.print("Enter id you want to search:");
         	   int id = sc.nextInt();
         	   Student student = studentDaoImpl.getById(id);
         	   if(student !=null) {
         		   System.out.println(student );
         	   }
         	   else {
         		   System.out.println("student  with given id not found");
         	   }
        	}else if(choice ==4) {
        		System.out.print("Enter id:");
         	   int id = sc.nextInt();
         	   int result = studentDaoImpl.remove(id);
         	   if(result!=-1) {
         		   System.out.println("student removed!");
         	   }
         	   else {
         		   System.out.println("student with given id not found");
         	   }
            }
            else {
         	  System.out.println("Invalid choice"); 
            }
            System.out.print("Do you want to continue? (Y/N)");
            continuationChoice = sc.next().charAt(0);
        }while(continuationChoice=='Y');
        	}
        }
    

