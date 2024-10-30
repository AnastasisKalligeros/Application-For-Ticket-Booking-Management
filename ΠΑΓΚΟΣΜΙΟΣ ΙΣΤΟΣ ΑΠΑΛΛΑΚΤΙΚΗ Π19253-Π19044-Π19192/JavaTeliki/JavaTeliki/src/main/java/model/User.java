package model;

import utilities.ServletUtilities;


/**
 * @authors Zannis, Loizidis, Stylianou, Kontopoulos
 *
 */
public abstract class User {
	
	

	private String username;
	private String email;


	private String password;
	private String name;
	private String surname;
	private String department;
	private String role;
	private static int userCounter = 0;

	
	public User() { 
		userCounter+=1;
	}
	
	
		
	

	public void setUsername(String username) throws Exception {
		if(username.contains(" ")) {
			throw new Exception("The username field contains spaces!");
		}
		
		if(ServletUtilities.checkIfEmpty(username))
			throw new Exception("The username field is empty!");
		
		username = ServletUtilities.filter(username);
		this.username = username;
	}

	public void setPassword(String password) throws Exception {
		if(ServletUtilities.checkIfEmpty(password))
			throw new Exception("The password field is empty!");
		
		password = ServletUtilities.filter(password);
		this.password = password;
	}
	
	public void setName(String name) throws Exception {
		if(ServletUtilities.checkIfEmpty(name))
			throw new Exception("The name field is empty!");
	
		name = ServletUtilities.filter(name);
		this.name = name;
	}

	public void setSurname(String surname) throws Exception {
		if(ServletUtilities.checkIfEmpty(surname))
				throw new Exception("The surname field is empty!");
			
		surname = ServletUtilities.filter(surname);
		this.surname = surname;
	}

	public void setDepartment(String department) throws Exception {
		if(ServletUtilities.checkIfEmpty(department))
			throw new Exception("The department field is empty!");
		
		department = ServletUtilities.filter(department);
		this.department = department;
	}

	public void setRole(String role) throws Exception {
		if(ServletUtilities.checkIfEmpty(role))
			throw new Exception("The role field is empty!");
		
		role = ServletUtilities.filter(role);
		this.role = role;
	}

	public static int getUserCounter() {
		return userCounter;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getDepartment() {
		return department;
	}

	public String getRole() {
		return role;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return " Name: " + name
			 + "\n Surname: " + surname
			 + "\n Username: " + username
			 + "\n Password: " + password
			 + "\n Department: " + department
			 + "\n Role: " + role;
	}
	
	public void Register() { }
	
	public void LogIn() { }
	
	public void LogOut() { }
	
	}
	



