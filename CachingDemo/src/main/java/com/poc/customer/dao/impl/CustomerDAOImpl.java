package com.poc.customer.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.poc.customer.dao.CustomerDAO;
import com.poc.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	
	public static Map<String,Customer> customerDB=new HashMap<String,Customer>();
	
	static {
		customerDB.put("1",new Customer("1","Penny","pasadena"));
		customerDB.put("2",new Customer("2","Sheldon","fremont"));
		customerDB.put("3",new Customer("3","Bernadatte","sfo"));
		customerDB.put("4",new Customer("4","Red","pasadena"));
		customerDB.put("5",new Customer("5","Kitty","fremont"));
		customerDB.put("6",new Customer("6","Eric","sfo"));
		customerDB.put("7",new Customer("7","Donna","sfo"));
	}
	
	public Customer getCustomer(String custId){
		if(null!=customerDB && null!=customerDB.get(custId)){
			//System.out.println("Fetched From DB ");
			return customerDB.get(custId);
		}else{
			System.out.println("No Record in DB ");
			return null;
		}
		
	}
	
	public void addCustomer(Customer customer){
		if(null!=customerDB){
			System.out.println("Adding Record :" + customer + " to DB ");
			customerDB.put(customer.getCustNo(),customer);
		}
	}
	
}
