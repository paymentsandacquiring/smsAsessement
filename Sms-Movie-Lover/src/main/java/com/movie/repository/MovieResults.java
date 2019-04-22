package com.movie.repository;

import java.util.HashMap;

import com.example.demo.Movie;
import com.movie.model.DisplayMovie;

public class MovieResults {
	private HashMap<String, Movie> movieResults;
	private HashMap<String, DisplayMovie> displayMovieReults;
	private HashMap<String, String> movieGenres;
	private HashMap<String, String> moviePublishers;
	private String formattedGenre;
	private String formattedPublisher;
	
	public MovieResults() {
		this.movieResults = new HashMap<>();
		this.movieGenres = new HashMap<>();
		this.moviePublishers = new HashMap<>();
		this.displayMovieReults = new HashMap<>();
		this.formattedGenre = this.formattedPublisher = "";
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
		this.movieGenres.put(movieGenre, movieGenre);
		this.formattedGenre = "";
	}
	
	public HashMap<String, String> getMovieGenre() {
		return this.movieGenres;
	}
	
	public void setMoviePublisher(String moviePublisher) {
		this.moviePublishers.put(moviePublisher, moviePublisher);
		this.formattedPublisher = "";
	}
	
	public HashMap<String, String> getMoviePublisher() {
		return this.moviePublishers;
	}
	
	public String formatGenre() {
		
		this.movieGenres.forEach((k, v)->{
			formattedGenre += this.movieGenres.get(v)+", ";
		});
		formattedGenre = formattedGenre.substring(0, formattedGenre.length() - 2);
		return formattedGenre;
	}
	public String formatPublisher() {
		System.out.println(moviePublishers);
		this.moviePublishers.forEach((k, v)->{
			formattedPublisher += this.moviePublishers.get(v)+", ";
		});
		formattedPublisher = formattedPublisher.substring(0, formattedPublisher.length() - 2);
		return formattedPublisher;
	}
}