package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cinema;
import model.ContentAdmin;
import model.Customer;
import model.Film;
import model.Movie;
import model.Reservation;
import utilities.DbUtil;


public class ReservationDao {
	private Connection connection;
	
	public ReservationDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addReservation(int movieID, String movieName, int cinemaID, int customerID, int numberofseats)
	{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reservations VALUES(?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, movieID);
			preparedStatement.setString(2, movieName);
			preparedStatement.setInt(3, cinemaID);
			preparedStatement.setInt(4, customerID);
			preparedStatement.setInt(5, numberofseats);		
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
