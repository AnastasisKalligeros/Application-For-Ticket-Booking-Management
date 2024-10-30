package dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ContentAdmin;
import model.Movie;
import model.User;
import model.CreateUser;
import utilities.DbUtil;


 

public class UserDao {
	private Connection connection;
	
	public UserDao() {
		connection = DbUtil.getConnection();
    }
	
	


	public boolean usernameCheck(String username) {
		boolean answer = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) 
            { 
            	answer = true;
        	}
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
		
	public String getSalt(String username) {
		String salt=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT salt FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) 
            { 
            	salt=rs.getString("salt");
        	} 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salt;
	}
	
	public boolean passwordCheck(String username,String password) {
		boolean connected=false;
		try {
            	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER where (username=? and password=?)");
            	preparedStatement.setString(1, username);
            	preparedStatement.setString(2, password);
            	ResultSet rs = preparedStatement.executeQuery();
            	if (rs.next() == false) 
            	{ 
            		connected=false;
            	} 
            	else 
            	{ 
            		connected=true;
            	}

        	} catch (SQLException e) {
            e.printStackTrace();
        	}
        return connected;
	}
		
	public String getRole(String username) {
		String role=null;
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT role FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet rs1 = preparedStatement.executeQuery();
            if (rs1.next() == true) 
            { 
            	 role = rs1.getString("role");
            	 
        	}
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return role;
	}
	
	public void addUser(String username,String email, String password, String salt, String role) 
	{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER (username,email, password, salt, role) VALUES ( ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, salt);
			preparedStatement.setString(5, role);
			preparedStatement.executeUpdate();
						
		}catch(SQLException e) {
            e.printStackTrace();
        }		
	}
	
	
	
	public void deleteContentAdmin(String username) {
	    try {
	    	

	        PreparedStatement PreparedStatement = connection.prepareStatement("DELETE FROM content_admin WHERE username = ?");
	        PreparedStatement.setString(1, username);       
	        PreparedStatement.executeUpdate();
	    	
	    	
	        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USER WHERE username = ?");
	        preparedStatement.setString(1, username);       
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();	    
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	
	}
	
	public List<CreateUser> getAllUsers() {
		List<CreateUser> users = new ArrayList<CreateUser>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT username,email,role FROM user");
			while (rs.next()) {
				CreateUser user = new CreateUser();
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
			
	      		
			
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


