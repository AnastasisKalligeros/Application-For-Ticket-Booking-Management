package model;

import utilities.ServletUtilities;


public class Customer extends User {

private String customerid;
	
	public Customer() {
		super();
	}

	public String getcustomerid() {
		return customerid;
	}


	public void setCustomerid(String customerid) throws Exception {
		if(ServletUtilities.checkIfEmpty(customerid))
			throw new Exception("ID field is empty!");
		
		customerid = ServletUtilities.filter(customerid);
		this.customerid = customerid;
	}
}
