package com.movie.repository;

import java.util.HashMap;

import com.example.demo.Movie;
import com.movie.model.DisplayMovie;

public class MovieResults {
	private HashMap<String, Movie> movieResults;
	private HashMap<String, DisplayMovie> displayMovieReults;
	private String movieGenres;
	private String moviePublishers;
	
	public MovieResults() {
		this.movieResults = new HashMap<>();
		this.movieGenres = "";
		this.moviePublishers = "";
		this.displayMovieReults = new HashMap<>();
;	}
	
	public HashMap<String, Movie> getAllMovieResults() {
		return this.movieResults;
	}
	
	public void setAllMovieResults(Movie movie) {
		this.movieResults.put(String.valueOf(movie.getMovieId()), movie);
	}
	
	public void setMovieDisplayResults(String movieId, DisplayMovie displayMovie) {
		this.displayMovieReults.put(movieId, displayMovie);
	} 
	
	public HashMap<String, DisplayMovie> getMovieDisplayResults() {
		return this.displayMovieReults;
	}
	
	public void setMovieGenre(String movieGenre) {
		movieGenre += " "+movieGenre;
	}
	
	public String getMovieGenre() {
		return this.movieGenres;
	}
	
	public void setMoviePublisher(String moviePublisher) {
		moviePublisher += " "+moviePublisher;
	}
	
	public String getMoviePublisher() {
		return this.moviePublishers;
	}
	
}