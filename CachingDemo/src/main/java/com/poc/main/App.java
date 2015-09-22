package com.poc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poc.customer.bo.CustomerBo;
import com.poc.model.Customer;

public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");

		CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
		
		
		
		System.out.println("****************");
		customer.getCustomerCacheAOP("1");
		System.out.println("****************");
		customer.getCustomerCacheAOP("2");
		System.out.println("****************");
		customer.getCustomerCacheAOP("3");
		System.out.println("****************");
		customer.getCustomerCacheAOP("4");
		System.out.println("****************");
		customer.getCustomerCacheAOP("5");
		System.out.println("****************");
		customer.getCustomerCacheAOP("6");
		System.out.println("****************");
		customer.getCustomerCacheAOP("7");
		System.out.println("****************");
		customer.addCustomer(new Customer("8","Howard","sanjose"));
		System.out.println("****************");
		customer.getCustomerCacheAOP("8");
		
	
		
	}
}