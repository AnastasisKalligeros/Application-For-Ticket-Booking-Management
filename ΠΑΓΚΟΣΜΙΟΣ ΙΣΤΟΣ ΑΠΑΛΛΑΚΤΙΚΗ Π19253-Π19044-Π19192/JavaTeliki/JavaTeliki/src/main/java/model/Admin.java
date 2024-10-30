package model;

import utilities.ServletUtilities;


public class Admin extends User {

private String adminid;
	
	public Admin() {
		super();
	}

	public String getadminid() {
		return adminid;
	}


	public void setadminid(String adminid) throws Exception {
		if(ServletUtilities.checkIfEmpty(adminid))
			throw new Exception("ID field is empty!");
		
		adminid = ServletUtilities.filter(adminid);
		this.adminid = adminid;
	}
}
