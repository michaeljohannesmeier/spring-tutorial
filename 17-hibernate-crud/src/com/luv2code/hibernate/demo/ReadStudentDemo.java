package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			// create a student object
			System.out.println("Creating new student...");
			Student tempStudent = new Student("Duffy", "Duck", "dd@luv2code.com");
			
			// start the transaction
			session.beginTransaction();
			
			
			// save the student
			System.out.println("Saving student...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// get generated id
			System.out.println("Save student. Generated id: " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession()
;
			// retrieve student based on id
			session.beginTransaction();
			Student myStudent = session.get(Student.class,  tempStudent.getId());
			System.out.println("Red student: " + myStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

}
