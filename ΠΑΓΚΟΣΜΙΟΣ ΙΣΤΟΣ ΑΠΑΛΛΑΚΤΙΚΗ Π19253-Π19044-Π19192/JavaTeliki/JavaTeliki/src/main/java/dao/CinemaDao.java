package dao;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilities.DbUtil;

import model.Movie;
import model.Film;
import model.Cinema;
import model.ContentAdmin;
import model.User;


public class CinemaDao {
	private Connection connection;

	
	public CinemaDao() {
		connection = DbUtil.getConnection();
	}

	
	
	public Cinema getCinema(String cinemaID) {
		Cinema cinema = new Cinema();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cinemas WHERE CINEMA_ID=?");
			preparedStatement.setString(1, cinemaID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				cinema.setCinemaID(rs.getString("ID"));
				cinema.setName(rs.getString("NAME"));
				cinema.setSeats(rs.getString("SEATS"));
				cinema.setD3(rs.getBoolean("3D"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cinema;
	}
	
	public Cinema getCinemaID(String cinemaID) {
		Cinema cin = new Cinema();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cinemas WHERE CINEMA_ID=?");
			preparedStatement.setString(1, cinemaID);
			ResultSet rs1 = preparedStatement.executeQuery();
			
			if (rs1.next()) {
				cin.setCinemaID(rs1.getString("CINEMA_ID"));
				cin.setName(rs1.getString("NAME"));
				cin.setSeats(rs1.getString("SEATS"));
				cin.setD3(rs1.getBoolean("3D"));
						
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cin;
	}
	
	
	
	

}
