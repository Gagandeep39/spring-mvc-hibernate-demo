/**
 * Gagandeep
 * 12:51:03 am
 * 06-Apr-2020
 */
package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Customer;

/**
 * 
 * @author Gagandeep
 *
 * Will automtically scan it as a dao implementation
 * Will also handle JDBC related exception
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	// Autowired will inhect the session factory from xml configuration
	@Autowired
	private SessionFactory sessionFactory;

	
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}



	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
//		session.save(customer);
		// New custoer will have no id
		// Common method for add and jupdate
		session.saveOrUpdate(customer); 
	}



	@Override
	public Customer fetchCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}



	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
//		Query query = session.createQuery("delete from Customer where id=:customerId");
//		query.setParameter("customerId", id);
//		query.executeUpdate();
	}

}
