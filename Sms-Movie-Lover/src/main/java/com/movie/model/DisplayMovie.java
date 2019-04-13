package com.movie.model;

public class DisplayMovie {
	private String moviePublisher;
	private String movieYear;
	private String movieGenre;
	private String movieName;
	
	public DisplayMovie(String movieName, String movieYear, String movieGenre, String moviePublisher) {
		this.moviePublisher = moviePublisher;
		this.movieYear = movieYear;
		this.movieGenre = movieGenre;
		this.movieName = movieName;
	}
	
	public DisplayMovie() {
		this.movieGenre = this.movieName = this.moviePublisher = this.movieYear = "";
	}
	
	public String getMoviePublisher() {
		return moviePublisher;
	}
	public String getMovieYear() {
		return movieYear;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMoviePublisher(String moviePublisher) {
		this.moviePublisher = moviePublisher;
	}
	public void setMovieYear(String movieYear) {
		this.movieYear = movieYear;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
}
