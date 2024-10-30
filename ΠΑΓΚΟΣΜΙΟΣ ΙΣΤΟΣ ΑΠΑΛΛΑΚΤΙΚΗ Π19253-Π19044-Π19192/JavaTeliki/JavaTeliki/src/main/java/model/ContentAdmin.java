package model;

import utilities.ServletUtilities;


public class ContentAdmin extends User {
	
	private String contentadminid;
	
	public ContentAdmin() {
		super();
	}

	public String getContentadminid() {
		return contentadminid;
	}


	public void setContentadminid(String contentadminid) throws Exception {
		if(ServletUtilities.checkIfEmpty(contentadminid))
			throw new Exception("ID field is empty!");
		
		contentadminid = ServletUtilities.filter(contentadminid);
		this.contentadminid = contentadminid;
	}
}
