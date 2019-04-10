package com.movie.service;

import java.util.HashMap;

import com.example.demo.Movie;
import com.example.demo.MovieCast;
import com.example.demo.MovieGenre;
import com.example.demo.MoviePublisher;
import com.example.demo.MovieRater;
import com.movie.repository.MovieRepository;

public class MovieService {
	private MovieRepository movieRepository;
	
	public MovieService() {
		this.movieRepository = new MovieRepository();
	}
	
	public HashMap<String, String> addMovie(Movie movie) {
		HashMap<String, String> hashMap = new HashMap<>();
		if(isMovieAlreadyAdded(movie.getMovieName(), movie.getMovieYear())) {
			hashMap.put("code", "Movie already exists");
			return hashMap;
		}
		hashMap = movieRepository.addMovie(movie);
		
		return hashMap;
	}
	
	public HashMap<String, String> addGenre(Movie movie, MovieGenre genre) {
		HashMap<String, String> hashMap = new HashMap<>();
		if(isGenreAlreadyAdded(genre.getGenreName())) {
			hashMap.put("code", "Genre already exists");
			hashMap = addMovieGenreMiddle(movie, genre, hashMap);
			return hashMap;
		}
		hashMap = movieRepository.addGenre(genre);				
		hashMap = addMovieGenreMiddle(movie, genre, hashMap);
		return hashMap;
	}
	
	public HashMap<String, String> addPublisher(Movie movie, MoviePublisher publisher) {
		HashMap<String, String> hashMap = new HashMap<>();
		if(isPublisherAlreadyAdded(publisher.getPublisherName())) {
			hashMap.put("code", "Publisher already exists");
			hashMap = addMoviePublisherMiddle(movie, publisher, hashMap);
			return hashMap;
		}
		
		hashMap = movieRepository.addPublisher(publisher);
		hashMap = addMoviePublisherMiddle(movie, publisher, hashMap);
		
		return hashMap;
	}
	
	public HashMap<String, String> addCast(Movie movie, MovieCast cast) {
		HashMap<String, String> hashMap = new HashMap<>();
		if(isCastAlreadyAdded(cast.getActorFirstName(), cast.getActorLastName(), cast.getNameInMovie())) {
			hashMap.put("code", "Cast already exists");
			addMovieCastMiddle(movie, cast, hashMap);
			return hashMap;
		}
		
		hashMap = movieRepository.addCast(cast);
		addMovieCastMiddle(movie, cast, hashMap);
		
		return hashMap;
	}
	
	public HashMap<String, String> addRater(Movie movie, MovieRater rater, double raterRating) {
		HashMap<String, String> hashMap = new HashMap<>();
		if(isRaterAlreadyAdded(rater.getRaterName())) {
			hashMap.put("code", "Rater already exists");
			addMovieRaterMiddle(movie, rater, raterRating, hashMap);
			return hashMap;
		}
		
		hashMap = movieRepository.addRater(rater);
		addMovieRaterMiddle(movie, rater, raterRating, hashMap);
		
		return hashMap;
	}
	
	//getting the id for the middle tables
	//get movie id
	private int getMovieId(String movieName, String movieYear) {
		return movieRepository.getIdUsingTwoCol("movie_name", "movie_year", "movie", movieName, movieYear, "movie_id");
	}
	//get genre id
	private int getGenreId(String genreName) {
		return movieRepository.getIdUsingOneCol("genre_name", "movie_genre", genreName, "genre_id");
	}
	//get publisher id
	private int getPublisherId(String publisherName) {
		return movieRepository.getIdUsingOneCol("publisher_name", "movie_publisher", publisherName, "publisher_id");
	}
	//get rater id
	private int getRaterId(String raterName) {
		return movieRepository.getIdUsingOneCol("rater_name", "movie_rater", raterName, "rater_id");
	}
	//get cast id
	private int getCastId(String actorFirstName, String actorLastName, String nameInMovie) {
		return movieRepository.getIdUsingThreeCol("actor_first_name", "actor_last_name", "name_in_movie", "movie_cast", actorFirstName, actorLastName, nameInMovie, "cast_id");
	}
	
	//adding values to middle tables
	private HashMap<String, String> addMovieGenreMiddle(Movie movie, MovieGenre genre, HashMap<String, String> hashMap) {
		int movieId = getMovieId(movie.getMovieName(), movie.getMovieYear());
		int genreId = getGenreId(genre.getGenreName());
		hashMap = movieRepository.addMovieGenreMiddle(movieId, genreId);
		System.out.println("Add Movie Genre Middle id: "+movieId+" Genre Id:"+genreId);
		return hashMap;
	}
	private HashMap<String, String> addMoviePublisherMiddle(Movie movie, MoviePublisher publisher, HashMap<String, String> hashMap) {
		int movieId = getMovieId(movie.getMovieName(), movie.getMovieYear());
		int publisherId = getPublisherId(publisher.getPublisherName());
		hashMap = movieRepository.addMoviePublisherMiddle(movieId, publisherId);
		System.out.println("Add Movie Publisher Middle id: "+movieId+" Publisher Id:"+publisherId);
		return hashMap;
	}
	private HashMap<String, String> addMovieCastMiddle(Movie movie, MovieCast cast, HashMap<String, String> hashMap) {
		int movieId = getMovieId(movie.getMovieName(), movie.getMovieYear());
		int castId = getCastId(cast.getActorFirstName(), cast.getActorLastName(), cast.getNameInMovie());
		hashMap = movieRepository.addMovieCastMiddle(movieId, castId);
		System.out.println("Add Movie Cast Middle id: "+movieId+" Cast Id:"+castId);
		return hashMap;
	}
	private HashMap<String, String> addMovieRaterMiddle(Movie movie, MovieRater rater, double raterRating, HashMap<String, String> hashMap) {
		int movieId = getMovieId(movie.getMovieName(), movie.getMovieYear());
		int raterId = getRaterId(rater.getRaterName());
		hashMap = movieRepository.addMovieRaterMiddle(movieId, raterId, raterRating);
		System.out.println("Add Movie Rater Middle id: "+movieId+" Rater Id:"+raterId);
		return hashMap;
	}
	
	//validate
	//check if the movie exists
	private boolean isMovieAlreadyAdded(String movieName, String movieYear) {
		if(movieRepository.getIdUsingTwoCol("movie_name", "movie_year", "movie", movieName, movieYear, "movie_id") == -1)
			return false;
		return true;
	}
	//check if the genre exists	
	private boolean isGenreAlreadyAdded(String genreName) {
		if(movieRepository.getIdUsingOneCol("genre_name", "movie_genre", genreName, "genre_id") == -1)
			return false;
		return true;
	}
	//check if the publisher exists
	private boolean isPublisherAlreadyAdded(String publisherName) {
		if(movieRepository.getIdUsingOneCol("publisher_name", "movie_publisher", publisherName, "publisher_id") == -1)
			return false;
		return true;
	}
	//check if the rater exists
	private boolean isRaterAlreadyAdded(String raterName) {
		if(movieRepository.getIdUsingOneCol("rater_name", "movie_rater", raterName, "rater_id") == -1)
			return false;
		return true;
	}
	//check if the cast exists
	private boolean isCastAlreadyAdded(String actorFirstName, String actorLastName, String nameInMovie) {
		if(movieRepository.getIdUsingThreeCol("actor_first_name", "actor_last_name", "name_in_movie", "movie_cast", actorFirstName, actorLastName, nameInMovie, "cast_id") == -1)
			return false;
		return true;
	}
}//end class