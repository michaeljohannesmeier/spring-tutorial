package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			

			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			Student myStudent = session.get(Student.class,  studentId);
//			System.out.println("Red student: " + myStudent);
			
			// delete one student
			//session.delete(myStudent);
			//session.getTransaction().commit();
			
			// delete student with id 2
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

}
