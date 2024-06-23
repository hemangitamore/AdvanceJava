package com.example.oneToManyDemo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session=  new Configuration().configure().addAnnotatedClass(Department.class).addAnnotatedClass(Employe.class).buildSessionFactory().openSession();
       session.beginTransaction();
        
        
        
//        Department dept=new Department();
//        dept.setName("sales");
//        dept.setBlock("A");
//        dept.setHod("Mr.Ramesh");
//        
//        
//        Employe e1=new Employe();
//        e1.setName("Naman");
//        e1.setSalary(8765);
//        
//        Employe e2=new Employe();
//        e2.setName("Aman");
//        e2.setSalary(8965);
//        
//        e1.setDepartment(dept);
//        e2.setDepartment(dept);
//        
//        dept.getEmployees().add(e1);
//        dept.getEmployees().add(e2);
//        
//        session.save(dept);
//        session.save(e1);
//        session.save(e2);
       
//    Employe e1=   session.get(Employe.class,1);
//        System.out.println(e1);
       
     Department d1=  session.get(Department.class, 1);
     System.out.println(d1);
       
        session.getTransaction().commit();
        
        
    }
}
