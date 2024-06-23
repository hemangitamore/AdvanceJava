package com.example.onetooneDemo;



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
//        Person p=new Person();
//        p.setName("Aditi");
//        p.setPhone("9876");
//        
//        
//        Address adrs=new Address();
//        adrs.setHouseNo("B/187");
//        adrs.setCity("Mumbai");
//        adrs.setArea("Malad");
        
       // p.setAddress(adrs);
       // adrs.setPerson(p);
        
      Session session=  new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Address.class).buildSessionFactory().openSession();
      Transaction txn=session.beginTransaction();
//    Person p=  session.get(Person.class, 1);
//    System.out.println(p);
//    System.out.println(p.getAddress());
      //session.save(p);
     // session.save(adrs);
      
   Address adrs=   session.get(Address.class, 1);
   System.out.println(adrs);
   System.out.println(adrs.getPerson());
      
      txn.commit();
      
    }
}
