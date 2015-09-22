package com.poc.customer.dao;

import com.poc.model.Customer;

public interface CustomerDAO {

	public Customer getCustomer(String custId);
	
	public void addCustomer(Customer customer);

}
