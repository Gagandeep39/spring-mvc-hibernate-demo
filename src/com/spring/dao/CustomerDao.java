/**
 * Gagandeep
 * 12:50:20 am
 * 06-Apr-2020
 */
package com.spring.dao;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();
	
	public void addCustomer(Customer customer);
	
	public Customer fetchCustomer(int id);

	public void deleteCustomer(int id);

}
