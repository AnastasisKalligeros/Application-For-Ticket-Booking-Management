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
import model.Movie;
import model.User;
import model.CreateUser;
import model.Film;
import utilities.DbUtil;





 

public class FilmDao {
	private Connection connection;
	
	public FilmDao() {
		connection = DbUtil.getConnection();
    }
	
	public List<Film> getAllFilms() {
		List<Film> films = new ArrayList<Film>();
		MovieDao movieDao = new MovieDao();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT TIME,NAME FROM provoles");
			while (rs.next()) {
				Film flm = new Film();
			
				flm.setTime(rs.getString("TIME"));
				String movieName = rs.getString("NAME");
				Movie mov = movieDao.getMovieName(movieName);
				flm.setMovie(mov);
				films.add(flm);
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return films;
	}

	
	public List<Film> getAllProvoles() {
		Film films = new Film();
		List<Film> provoles = new ArrayList<Film>();
		MovieDao movieDao = new MovieDao();
		CinemaDao cinemaDao = new CinemaDao();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT ID,NAME,CINEMAS_ID,TIME FROM provoles");
			while (rs.next()) {
				
				String movieID = rs.getString("ID");
				Movie mov = movieDao.getMovieID(movieID);
				films.setTime(rs.getString("TIME"));
				String movieName = rs.getString("NAME");
				Movie mo = movieDao.getMovieName(movieName);;
				String cinemaID = rs.getString("CINEMAS_ID");
				Cinema ci = cinemaDao.getCinemaID(cinemaID);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return provoles;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

	public void addFilm(String movieID, String movieName, String cinemaID, String provolesID, String contentadminid, String time) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO provoles (ID, MOVIE_NAME, CINEMAS_ID,PROVOLES_ID,CONTENT_ADMIN_ID, TIME) VALUES(?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, movieID);
			preparedStatement.setString(2, movieName);
			preparedStatement.setString(3, cinemaID);
			preparedStatement.setString(4, provolesID);
			preparedStatement.setString(5, contentadminid);
			preparedStatement.setString(6, time);
												
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


