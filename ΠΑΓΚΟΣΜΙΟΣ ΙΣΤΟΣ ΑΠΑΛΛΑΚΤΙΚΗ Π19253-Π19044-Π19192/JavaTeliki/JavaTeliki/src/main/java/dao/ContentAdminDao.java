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
import model.Film;
import utilities.DbUtil;


public class ContentAdminDao {
	
	private Connection connection;
	
	public ContentAdminDao() {
		connection = DbUtil.getConnection();
	}
	
	public ContentAdmin getContentadminid(String contentadminid) {
		ContentAdmin con = new ContentAdmin();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM content_admin JOIN user USING(username) WHERE ID=?");
			preparedStatement.setString(1, contentadminid);
			ResultSet rs1 = preparedStatement.executeQuery();
			
			if (rs1.next()) {
				con.setContentadminid(rs1.getString("ID"));
				con.setUsername(rs1.getString("Username"));
				con.setName(rs1.getString("Name"));
				con.setRole(rs1.getString("role"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	
	public void setUser(String username, String email, String role) {
	    PreparedStatement preparedStatement;
	    try {
	        preparedStatement = connection.prepareStatement("UPDATE user SET email=?, role=? WHERE username=?");

	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, role);
	        preparedStatement.setString(3, username);
	  
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public Film getTime(String time) {
		Film ti = new Film();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT TIME FROM provoles WHERE ID=?");
			preparedStatement.setString(1, time);
			ResultSet rs1 = preparedStatement.executeQuery();
			
			if (rs1.next()) {
				ti.setTime(rs1.getString("TIME"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ti;
	}
	
	
	
	
	
	
	
	
	
	
	public Cinema getCinemaid(String cinemaid) {
		Cinema cin = new Cinema();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT CINEMAS_ID FROM provoles WHERE ID=?");
			preparedStatement.setString(1, cinemaid);
			ResultSet rs1 = preparedStatement.executeQuery();
			
			if (rs1.next()) {
				cin.setCinemaID(rs1.getString("CINEMAS_ID"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public List<ContentAdmin> getAllContentAdmins() {
		List<ContentAdmin> contentadmins = new ArrayList<ContentAdmin>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs1 = statement.executeQuery("SELECT * FROM content_admin JOIN user USING(username)");
			
			while (rs1.next()) {
				ContentAdmin con = new ContentAdmin();
				con.setContentadminid(rs1.getString("ID"));
				con.setName(rs1.getString("NAME"));
				con.setUsername(rs1.getString("username"));
				con.setRole(rs1.getString("role"));																			
				contentadmins.add(con);
			
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return contentadmins;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ContentAdmin getContentAdminByUsername(String username) {
		ContentAdmin con = new ContentAdmin();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM content_admin NATURAL JOIN user WHERE username=?");
			preparedStatement.setString(1, username);
			ResultSet rs1 = preparedStatement.executeQuery();
			
			if (rs1.next()) {
				con.setUsername(rs1.getString("username"));
				con.setContentadminid(rs1.getString("ID"));
				con.setRole(rs1.getString("role"));
				con.setName(rs1.getString("name"));
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	
	
}
