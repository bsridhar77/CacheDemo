package com.poc.customercache.dao;

import com.poc.model.Customer;

public interface CustomerCacheDAO {
	
	public Customer getCustomer(String custId);
	
	public void addCustomer(Customer customer);
}
