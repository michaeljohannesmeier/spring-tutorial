package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> getCustomers() {
		
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get a query
		Query<Customer> theQuery = currentSession.createQuery(
				"from Customer order by lastName",
				Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the list
		return customers;
	}

	public void saveCustomer(Customer theCustomer) {
		
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get a query
		currentSession.saveOrUpdate(theCustomer);
		
	}

	public Customer getCustomer(int theId) {
		
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve customer with id
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
