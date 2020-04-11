/**
 * Gagandeep
 * 1:43:53 am
 * 06-Apr-2020
 */
package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void addCustomer(Customer customer);
	
	public Customer fetchCustomer(int id);

	public void deleteCustomer(int id);

}
