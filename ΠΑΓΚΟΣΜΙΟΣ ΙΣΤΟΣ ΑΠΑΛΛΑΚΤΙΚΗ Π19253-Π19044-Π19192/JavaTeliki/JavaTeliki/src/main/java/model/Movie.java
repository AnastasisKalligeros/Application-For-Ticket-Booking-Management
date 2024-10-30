package model;


public class Movie {
	
	private String movieID;
	private String movieName;
	private String movieContent;
	private String movieLength;
	private String movieType;
	private String movieSummary;
	private String movieDirector;
	private String movieCinemaID;
	private String movieTime;
	public String getMovieCinemaID() {
		return movieCinemaID;
	}


	public void setMovieCinemaID(String movieCinemaID) {
		this.movieCinemaID = movieCinemaID;
	}


	

	public String getMovieTime() {
		return movieTime;
	}


	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}




	private ContentAdmin contentadmin;
	private Cinema cinema;
	private Film film;
	
	
	public Film getFilm() {
		return film;
	}


	public void setFilm(Film film) {
		this.film = film;
	}


	public Cinema getCinema() {
		return cinema;
	}


	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}


	public Movie() {
		
		
	}


	public String getMovieID() {
		return movieID;
	}


	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getMovieContent() {
		return movieContent;
	}


	public void setMovieContent(String movieContent) {
		this.movieContent = movieContent;
	}


	public String getMovieLength() {
		return movieLength;
	}


	public void setMovieLength(String movieLength) {
		this.movieLength = movieLength;
	}


	public String getMovieType() {
		return movieType;
	}


	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}


	public String getMovieSummary() {
		return movieSummary;
	}


	public void setMovieSummary(String movieSummary) {
		this.movieSummary = movieSummary;
	}


	public String getMovieDirector() {
		return movieDirector;
	}


	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}


	public ContentAdmin getContentadmin() {
		return contentadmin;
	}


	public void setContentadmin(ContentAdmin contentadmin) {
		this.contentadmin = contentadmin;
	}
	
		
}