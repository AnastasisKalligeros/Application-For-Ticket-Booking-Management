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
import model.Customer;
import model.Movie;
import utilities.DbUtil;


public class CustomerDao {
	private Connection connection;
	
	public CustomerDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addReservation(String ID, String NAME, String cinemaID, String customerid,  String numberOfSeats)
	{
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO reservations (ID, NAME, CINEMAS_ID, CUSTOMERS_ID, NUMBER_OF_SEATS  ) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, ID);
			preparedStatement.setString(2, NAME);
			preparedStatement.setString(3, cinemaID);
			preparedStatement.setString(4, customerid);
			preparedStatement.setString(5, numberOfSeats);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs1 = statement.executeQuery("SELECT * FROM customers JOIN user USING(username)");
			
			while (rs1.next()) {
				Customer mov = new Customer();
				mov.setCustomerid(rs1.getString("CUSTOMERS_ID"));
				mov.setName(rs1.getString("NAME"));
				mov.setUsername(rs1.getString("username"));
				mov.setRole(rs1.getString("role"));																			
				customers.add(mov);
			
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	public Customer getCustomerid(String customerid) {
		Customer cus = new Customer();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers JOIN user USING(username) WHERE ID=?");
			preparedStatement.setString(1, customerid);
			ResultSet rs1 = preparedStatement.executeQuery();
			
			if (rs1.next()) {
				cus.setCustomerid(rs1.getString("CUSTOMERS_ID"));
				cus.setUsername(rs1.getString("Username"));
				cus.setName(rs1.getString("Name"));
				cus.setRole(rs1.getString("role"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cus;
	}
	
	
	
	
}
