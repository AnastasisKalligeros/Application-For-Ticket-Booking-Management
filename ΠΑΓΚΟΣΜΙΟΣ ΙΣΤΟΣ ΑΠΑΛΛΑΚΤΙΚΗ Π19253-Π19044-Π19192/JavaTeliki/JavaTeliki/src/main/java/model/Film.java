package model;


public class Film {
	
	private String provolesID;
	private String ID;
	private String name;
	private String time;
	private String cinemaID;
	private String contentadminID;
	private Movie movie;
	
	
	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Film() {
		
		
	}


	public String getProvolesID() {
		return provolesID;
	}


	public void setProvolesID(String provolesID) {
		this.provolesID = provolesID;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getCinemaID() {
		return cinemaID;
	}


	public void setCinemaID(String cinemaID) {
		this.cinemaID = cinemaID;
	}


	public String getContentadminID() {
		return contentadminID;
	}


	public void setContentadminID(String contentadminID) {
		this.contentadminID = contentadminID;
	}


	
	
	


	
	
		
}