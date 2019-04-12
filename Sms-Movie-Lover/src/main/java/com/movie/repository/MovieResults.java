package com.movie.repository;

import java.util.HashMap;

import com.example.demo.Movie;

public class MovieResults {
	private HashMap<String, Movie> movieResults;
	
	public MovieResults() {
		this.movieResults = new HashMap<>();
	}
	
	public HashMap<String, Movie> getAllMovieResults() {
		return this.movieResults;
	}
	
	public void setAllMovieResults(Movie movie) {
		this.movieResults.put(String.valueOf(movie.getMovieId()), movie);
//		System.err.println(this.movieResults);
	}
}