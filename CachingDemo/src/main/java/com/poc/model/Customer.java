package com.poc.model;



public class Customer {

 
	String custno;

	
	public String toString(){
		StringBuffer strBuf=new StringBuffer();
		strBuf.append("  CustNo:").append(this.custno).append("  CustName:").append(this.custname).append("  CustCity:").append(this.custcity);
		return strBuf.toString();
		
	}
	public Customer(String custNo,String custName,String custCity){
		this.custno=custNo;
		this.custname=custName;
		this.custcity=custCity;
	}
	public String getCustNo() {
		return custno;
	}

	public void setCustNo(String custNo) {
		this.custno = custNo;
	}

	public String getCustName() {
		return custname;
	}

	public void setCustName(String custName) {
		this.custname = custName;
	}

	public String getCustCity() {
		return custcity;
	}

	public void setCustCity(String custCity) {
		this.custcity = custCity;
	}

	String custname;
	
	String custcity;
}
