package com.robert.RelationHibDemo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        System.out.println( "Hello World!" );
        
        Laptop lap1=new Laptop();
        lap1.setLapId(1);
        lap1.setlName("lapone");
        lap1.setPrice(10000);
      /*  Laptop lap2=new Laptop();
        lap2.setLapId(2);
        lap2.setlName("laptwo");
        lap2.setPrice(20000);*/
        Student s1=new Student();
        s1.setRollNo(1);
        s1.setName("Robert");
        s1.setMarks(100);
        s1.getLaptop().add(lap1);
      //  s1.getLaptop().add(lap2);
     
        Configuration cf=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf=cf.buildSessionFactory();
   /*     Session session1=sf.openSession();
        Transaction tx=session1.beginTransaction();
       // session.save(s1);
       // session.save(lap1);
        Student s=session1.get(Student.class, 1);
        System.out.println(s);
        tx.commit();
        session1.close();
    
        Session session2=sf.openSession();
        Transaction tx2=session2.beginTransaction();
        Student s2=session2.get(Student.class, 1);
        System.out.println(s2);
        tx2.commit();
        session2.close();*/
      
        /*
        List<Laptop> laps=s.getLaptop();
        for(Laptop l:laps){
        	System.out.println(l);
        }*/
        //tx.commit();
        Session session1=sf.openSession();
        Transaction tx=session1.beginTransaction();
       Student s= (Student) session1.createQuery("from Student where rollNo=2").setCacheable(true).uniqueResult();
       System.out.println(s);
       tx.commit();
       session1.close();
       
       Session session2=sf.openSession();
       Transaction tx2=session2.beginTransaction();
      Student s2= (Student) session2.createQuery("from Student where rollNo=2").setCacheable(true).uniqueResult();
      System.out.println(s2);
      tx2.commit();
      session2.close();
      
    }
}
