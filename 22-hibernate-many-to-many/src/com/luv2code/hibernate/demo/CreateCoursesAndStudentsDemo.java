package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;


public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
						
		
			// start the transaction
			session.beginTransaction();
			
			// create course
			Course tempCourse = session.get(Course.class, 21);
			
			// save the course and --> cascade all
			System.out.println("Saving course");
			
			// create students
			//Student tempStudent1 = session.get(Student.class, 6);
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			session.save(tempStudent2);
			
			
			// add students to course
			//tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			session.save(tempStudent2);
			
			
			//session.save(tempStudent2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

}
