/**
 * Gagandeep
 * 1:44:33 am
 * 06-Apr-2020
 */
package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao dao;

	/**
	 * @Transactional manages opening and closing of hibernate session
	 */
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer fetchCustomer(int id) {
		return dao.fetchCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
		
	}

}
