package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetail {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			// start the transaction
			session.beginTransaction();
			
			
			// get the objects
			int theId = 6;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			Instructor tempInstructor = tempInstructorDetail.getInstructor();
			
			// breaks bi directional link in case the delete should only delete the tempInstructorn
			// --> cascade should not be ALL
			tempInstructorDetail.getInstructor().setInstructorDetail(null);

			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println(tempInstructor);
			
			session.delete(tempInstructorDetail);
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
