package com.poc.customer.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.poc.aspect.CustomerCacheService;
import com.poc.customer.bo.CustomerBo;
import com.poc.customer.dao.CustomerDAO;
import com.poc.customer.dao.impl.CustomerDAOImpl;
import com.poc.model.Customer;

public class CustomerBoImpl implements CustomerBo {

	public static Map<String,Customer> customerDB=new HashMap<String,Customer>();
	
	public CustomerBoImpl(){
		/*customerDB.put("1",new Customer("1","Penny","pasadena"));
		customerDB.put("2",new Customer("2","Sheldon","fremont"));
		customerDB.put("3",new Customer("3","Bernadatte","sfo"));
		customerDB.put("4",new Customer("4","Red","pasadena"));
		customerDB.put("5",new Customer("5","Kitty","fremont"));
		customerDB.put("6",new Customer("6","Eric","sfo"));
		customerDB.put("7",new Customer("7","Donna","sfo"));*/
	}
	

	public Customer getCustomerCacheAOP(String custId) {
		return getCustomerFromDB(custId);
	}
	
	public Customer getCustomer(String custId) {
		
		CustomerCacheService cacheService=new CustomerCacheService();
		
		//Fetch From Cache
		Customer cust=cacheService.getCustomer(custId);
		
		//If Available in Cache
		if(null!=cust){
			//Return Fetched Value from Cache
			return cust;
		}else{//Not Available in Cache
			
			//Fetch From Database
			cust=getCustomerFromDB(custId);
			//Add Fetched Value to Cache
			cacheService.add(cust);
			//Return Fetched Value
			return cust;
		}
	}
	
	public void addCustomer(Customer customer) {
		CustomerDAO customerDAO=new CustomerDAOImpl();
		customerDAO.addCustomer(customer);
	}
	
	
	private Customer getCustomerFromDB(String custId){
		CustomerDAO customerDAO=new CustomerDAOImpl();
		return customerDAO.getCustomer(custId);
		
	}
	
}