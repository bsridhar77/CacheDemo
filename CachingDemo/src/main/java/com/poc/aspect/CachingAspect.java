package com.poc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.poc.model.Customer;

@Aspect
public class CachingAspect {

	
	
	@AfterReturning(
			pointcut = "execution(* com.poc.customer.bo.CustomerBo.addCustomer(..))",
			returning= "result")
	public void cacheUpdateCustomer(JoinPoint joinPoint, Object result) {
		joinPoint.getArgs();
		
		Object[] targetMethodParam= joinPoint.getArgs();
		Customer cust=(Customer)targetMethodParam[0];
		if(null!=cust){
			CustomerCacheService cacheService=new CustomerCacheService();
			cacheService.add(cust);
		}
	}
	
	


	@Around("execution(* com.poc.customer.bo.CustomerBo.getCustomerCacheAOP(..))")
	public Customer cacheGetCustomer(ProceedingJoinPoint joinPoint) throws Throwable {

		CustomerCacheService cacheService=new CustomerCacheService();
		Customer cust=null;
		
		
		Object[] targetMethodParam= joinPoint.getArgs();
		String methodParam=(String)targetMethodParam[0];
		
		if(null!=methodParam){
			cust=cacheService.getCustomer(methodParam);
			if(null==cust){
				cust=(Customer) joinPoint.proceed();
				if(null!=cust){
					System.out.println("Fetched from Database:" + cust);
					cacheService.add(cust);
				}
			}else{
				System.out.println("Fetched from Cache:" + cust);
			}
		}
		return cust;
	}
	
}