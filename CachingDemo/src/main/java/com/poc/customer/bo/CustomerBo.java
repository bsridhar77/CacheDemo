package com.poc.customer.bo;

import com.poc.model.Customer;

public interface CustomerBo {
	
	Customer getCustomer(String agentId);
	
	Customer getCustomerCacheAOP(String agentId);
	
	void addCustomer(Customer customer);
}