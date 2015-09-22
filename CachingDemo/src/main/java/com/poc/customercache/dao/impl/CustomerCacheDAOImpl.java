package com.poc.customercache.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.poc.customercache.dao.CustomerCacheDAO;
import com.poc.main.CassandraConnector;
import com.poc.model.Customer;

public class CustomerCacheDAOImpl implements CustomerCacheDAO {

	public static Map<String,Customer> customerCache=new HashMap<String,Customer>();
	
	final static CassandraConnector client = new CassandraConnector();
	
	static {
		   client.connect("localhost", 9042);
	}
	public Customer getCustomer(String custId) {
		
		System.out.println("Trying to Fetch Customer(" + custId +")" +" From Cache...");
		Statement select=QueryBuilder.select()
        .all()
        .from("myspace", "customer")
		.where(QueryBuilder.eq("custno", custId));
		
		
		ResultSet results = client.getSession().execute(select);
		Customer cust=null;
		for (Row row : results) {
			
			/*System.out.format("%s %s \n", row.getString("custname"),
					row.getString("custcity"));*/
			
			cust=new Customer(custId,row.getString("custname"),row.getString("custcity"));
		}
		if(cust==null){
			System.out.println("Requested Customer (" + custId +")" +" is not Available in CACHE.");	
		}else{
			System.out.println("Requested Customer (" + custId +")" +" Available in CACHE.");
		}
		return cust;
	}



	public void addCustomer(Customer customer) {
		System.out.println("Adding Customer (" + customer.getCustNo() +")" +"to Cache...");
		PreparedStatement statement = client.getSession().prepare(
				 
				"INSERT INTO customer" + "(custno,custname, custcity)"
						+ "VALUES (?,?,?) using TTL " + 100);
		 
				BoundStatement boundStatement = new BoundStatement(statement);
		 
				client.getSession().execute(boundStatement.bind(customer.getCustNo(),customer.getCustName(),customer.getCustCity()));
		
				System.out.println("Added Customer (" + customer.getCustNo() +") to Cache.");
		
	}
	
	
	
}
