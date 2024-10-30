package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ContentAdmin;
import model.CreateUser;
import model.Movie;
import utilities.DbUtil;


public class AdminDao {
	private Connection connection;
	
	public AdminDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addContentAdmin(int ID, String name, String username)
	{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO content_admin (ID, name,username) VALUES (?, ?, ?)");
			preparedStatement.setInt(1, ID);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, username);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addAdmin(int ID, String name, String username)
	{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admins (ID, name,username) VALUES (?, ?, ?)");
			preparedStatement.setInt(1, ID);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, username);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addCustomer(String CUSTOMERS_ID, String name, String username)
	{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers (CUSTOMERS_ID, name,username) VALUES (?, ?, ?)");
			preparedStatement.setString(1, CUSTOMERS_ID);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, username);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void deleteCustomer(String username) {
	    try {
	        // Delete customer first
	        PreparedStatement deleteCustomers = connection.prepareStatement("DELETE FROM customers WHERE username = ?");
	        deleteCustomers.setString(1, username);
	        deleteCustomers.executeUpdate();

	        // Delete user
	        PreparedStatement deleteUser = connection.prepareStatement("DELETE FROM USER WHERE username = ?");
	        deleteUser.setString(1, username);
	        deleteUser.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	public List<CreateUser> searchUsers(String username) {
	    List<CreateUser> users = new ArrayList<>();

	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, email, role FROM user WHERE username = ?");
	        preparedStatement.setString(1, username);

	        ResultSet rs = preparedStatement.executeQuery();

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
