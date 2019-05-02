package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and result list
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		// get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		// get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// save employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {

		// get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId", Employee.class);
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
