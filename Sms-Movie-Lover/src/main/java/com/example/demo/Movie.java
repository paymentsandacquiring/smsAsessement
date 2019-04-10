package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movieId", updatable = false, nullable = false)
	private int movieId;
	private String movieName;
	private String movieYear;
	
	public Movie() {
		this.movieId = 0;
		this.movieName = this.movieYear = "";
	}//end default constructor
		
	public Movie(int movieId, String movieName, String movieYearString) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieYear = movieYearString;
	}//end primary constructor
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(String movieYear) {
		this.movieYear = movieYear;
	}
}//end class