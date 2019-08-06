package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			

			// start the transaction
			session.beginTransaction();
			

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students
			displayStudents(theStudents);
			
			// query students with last name = doe
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();  
			
			// display the students
			System.out.println("\nStudents with last name dow");
			displayStudents(theStudents);
			
			
			// sudents with last name dow or fist name duffy
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Duffy'").list();  
			
			// display the students
			System.out.println("\nStudents with last name dow or first name duffy");
			displayStudents(theStudents);
			
			// sudents with email ends with luv2code.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list(); 
			
			// display the students
			System.out.println("\nStudents with email ends with luv2code.com");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
