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
import model.Reservation;
import model.Film;
import model.Cinema;
import model.ContentAdmin;
import model.User;


public class MovieDao {
	private Connection connection;
	private ContentAdminDao contentadminDao;
	private CinemaDao cinemaDao;
	
	public MovieDao() {
		connection = DbUtil.getConnection();
	}

	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		ContentAdminDao contentadminDao = new ContentAdminDao();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM movies");
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieID(rs.getString("ID"));
				movie.setMovieName(rs.getString("NAME"));
				movie.setMovieContent(rs.getString("CONTENT"));
				movie.setMovieLength(rs.getString("LENGTH"));
				movie.setMovieType(rs.getString("TYPE"));
				movie.setMovieSummary(rs.getString("SUMMARY"));
				movie.setMovieDirector(rs.getString("DIRECTOR"));
				movie.setMovieCinemaID(rs.getString("CINEMAS_ID"));
				movie.setMovieTime(rs.getString("TIME"));
				String contentadminid = rs.getString("CONTENT_ADMIN_ID");
	      		ContentAdmin con = contentadminDao.getContentadminid(contentadminid);
				movie.setContentadmin(con);
				
			
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	public Movie getMovieID(String movieID) {
		Movie mov = new Movie();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movie WHERE ID=?");
			preparedStatement.setString(1, movieID);
			ResultSet rs1 = preparedStatement.executeQuery();
			
			if (rs1.next()) {
				mov.setMovieID(rs1.getString("ID"));
				mov.setMovieName(rs1.getString("NAME"));
				mov.setMovieContent(rs1.getString("CONTENT"));
				mov.setMovieLength(rs1.getString("LENGTH"));
				mov.setMovieType(rs1.getString("TYPE"));
				mov.setMovieDirector(rs1.getString("DIRECTOR"));
				mov.setMovieCinemaID(rs1.getString("CINEMAS_ID"));
				mov.setMovieTime(rs1.getString("TIME"));
				String contentadminid = rs1.getString("CONTENT_ADMIN_ID");
	      		ContentAdmin con = contentadminDao.getContentadminid(contentadminid);
				mov.setContentadmin(con);
						
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mov;
	}
	
	public Movie getMovie(String movieID) {
		Movie movie = new Movie();
		ContentAdminDao contentadminDao = new ContentAdminDao();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movies WHERE ID=?");
			preparedStatement.setString(1, movieID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				movie.setMovieID(rs.getString("ID"));
				movie.setMovieName(rs.getString("NAME"));
				movie.setMovieContent(rs.getString("CONTENT"));
				movie.setMovieLength(rs.getString("LENGTH"));
				movie.setMovieType(rs.getString("TYPE"));
				movie.setMovieSummary(rs.getString("SUMMARY"));
				movie.setMovieDirector(rs.getString("DIRECTOR"));
				String contentadminid = rs.getString("CONTENT_ADMIN_ID");
				movie.setContentadmin(contentadminDao.getContentadminid(contentadminid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movie;
	}
	public boolean movieIdCheck(String movieID) {
		boolean answer = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID FROM movies WHERE ID=?");
            preparedStatement.setString(1, movieID);
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
	
	public void addMovie(String movieID, String movieName, String movieContent, String movieLength, String movieType, String movieSummary, String movieDirector, String movieCinemaID, String movieTime, String contentadminid) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO movies (ID, NAME, CONTENT,LENGTH, TYPE, SUMMARY, DIRECTOR,CINEMAS_ID,TIME,CONTENT_ADMIN_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, movieID);
			preparedStatement.setString(2, movieName);
			preparedStatement.setString(3, movieContent);
			preparedStatement.setString(4, movieLength);
			preparedStatement.setString(5, movieType);
			preparedStatement.setString(6, movieSummary);
			preparedStatement.setString(7, movieDirector);
			preparedStatement.setString(8, movieCinemaID);
			preparedStatement.setString(9, movieTime);
			preparedStatement.setString(10, contentadminid);
			preparedStatement.executeUpdate();
												
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void deleteMovie(String ID) {
	    try {
	    	
	        PreparedStatement PreparedStatement = connection.prepareStatement("DELETE FROM movies WHERE ID = ?");
	        PreparedStatement.setString(1, ID);       
	        PreparedStatement.executeUpdate();
	    		    		        
	    } catch (SQLException e) {
	        e.printStackTrace();	    
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	
	}


	public List<Movie> getAllProvoles() {
		List<Movie> movies = new ArrayList<Movie>();
		ContentAdminDao contentadminDao = new ContentAdminDao();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM movies");
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieID(rs.getString("ID"));
				movie.setMovieName(rs.getString("NAME"));
				movie.setMovieContent(rs.getString("CONTENT"));
				movie.setMovieLength(rs.getString("LENGTH"));
				movie.setMovieType(rs.getString("TYPE"));
				movie.setMovieSummary(rs.getString("SUMMARY"));
				movie.setMovieDirector(rs.getString("DIRECTOR"));
				String contentadminid = rs.getString("CONTENT_ADMIN_ID");
	      		ContentAdmin con = contentadminDao.getContentadminid(contentadminid);
				movie.setContentadmin(con);
				
			
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	
	
	
	
	public List<Reservation> getAllReservations() {
		List<Reservation> reservation = new ArrayList<Reservation>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM reservations");
			while (rs.next()) {
				Reservation reservations = new Reservation();
				reservations.setID(rs.getString("ID"));
				reservations.setName(rs.getString("NAME"));
				reservations.setCinemasID(rs.getString("CINEMAS_ID"));
				reservations.setCustomersID(rs.getString("CUSTOMERS_ID"));
				reservations.setNumberOfSeats(rs.getString("NUMBER_OF_SEATS"));
				
				reservation.add(reservations);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reservation;
	}
	
	
	
	
	public List<Movie> getProgram() {
		List<Movie> program = new ArrayList<Movie>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT NAME,LENGTH,CINEMAS_ID,TIME FROM movies");
			while (rs.next()) {
				Movie programs = new Movie();
				programs.setMovieName(rs.getString("NAME"));
				programs.setMovieLength(rs.getString("LENGTH"));
				programs.setMovieCinemaID(rs.getString("CINEMAS_ID"));
				programs.setMovieTime(rs.getString("TIME"));
			
				
				program.add(programs);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return program;
	}
	
	
	
	
	
	
	
	public Movie getMovieName(String movieName) {
	    Movie mov = new Movie();

	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement("SELECT NAME FROM movies WHERE NAME=?");
	        preparedStatement.setString(1, movieName);
	        ResultSet rs1 = preparedStatement.executeQuery();
	        
	        if (rs1.next()) {
	            mov.setMovieName(rs1.getString("NAME"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return mov;
	}

	
	
	
	
	
	
	

}
