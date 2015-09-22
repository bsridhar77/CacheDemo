package com.poc.aspect;

import com.poc.customercache.dao.CustomerCacheDAO;
import com.poc.customercache.dao.impl.CustomerCacheDAOImpl;
import com.poc.model.Customer;

public class CustomerCacheService {

	
	
	
	public CustomerCacheService(){
	
	}
	
	public Customer getCustomer(String custId) {
		CustomerCacheDAO customerCacheDAO=new CustomerCacheDAOImpl();
		//System.out.println("getCustomer(): Returning From Cache!");
		return customerCacheDAO.getCustomer(custId);
	}

	public void add(Customer customer) {
		//System.out.println("add(): Adding To Cache...!");
		CustomerCacheDAO customerCacheDAO=new CustomerCacheDAOImpl();
		customerCacheDAO.addCustomer(customer);
		//System.out.println("add(): Added To Cache!");
	}
  

}
