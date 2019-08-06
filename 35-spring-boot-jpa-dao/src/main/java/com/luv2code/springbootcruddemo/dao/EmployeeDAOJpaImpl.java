package com.luv2code.springbootcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.luv2code.springbootcruddemo.entity.Employee;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		Query theQuery =
				entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employee = theQuery.getResultList();
		
		return employee;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee theEmployee = 
				entityManager.find(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee = 
				entityManager.merge(theEmployee);
		
		// update with id from db
		// so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		Query theQuery = entityManager.createQuery(
				"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
