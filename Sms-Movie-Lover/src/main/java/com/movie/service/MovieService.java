package com.movie.service;

import java.util.HashMap;

import com.example.databasefactory.MovieLogger;
import com.example.demo.Movie;
import com.example.demo.MovieCast;
import com.example.demo.MovieGenre;
import com.example.demo.MoviePublisher;
import com.example.demo.MovieRater;
import com.example.demo.MovieUser;
import com.movie.model.DisplayMovie;
import com.movie.repository.MovieRepository;
import com.movie.repository.MovieResults;

public class MovieService {
	private MovieRepository movieRepository;
	
	public MovieService() {
		this(new MovieRepository(new MovieLogger(), new MovieResults()));
	}
	public MovieService(MovieLogger movieLogger, MovieResults movieResults) {
		this(new MovieRepository(movieLogger, movieResults));
	}
	
	public MovieService(MovieRepository repository) {
		this.movieRepository = repository;
	}
	
	public void addMovieUser(MovieUser movieUser) {
		if(isMovieUserAlreadyAdded(movieUser.getEmail())) {
			this.movieRepository.getMovieLogger().addCode("Movie already exists");
		}else {
			this.movieRepository.addMovieUser(movieUser);
		}
	}
	
	public void addMovie(Movie movie) {
		if(isMovieAlreadyAdded(movie.getMovieName(), movie.getMovieYear())) {
			this.movieRepository.getMovieLogger().addCode("Movie already exists");
		}else {
			this.movieRepository.addMovie(movie);
		}
	}
	
	public void addGenre(Movie movie, MovieGenre genre) {
		if(isGenreAlreadyAdded(genre.getGenreName())) {
			this.movieRepository.getMovieLogger().addCode("Genre already exists");
			addMovieGenreMiddle(movie, genre);
		}else {
			this.movieRepository.addGenre(genre);				
			addMovieGenreMiddle(movie, genre);
		}
	}
	
	public void addPublisher(Movie movie, MoviePublisher publisher) {
		if(isPublisherAlreadyAdded(publisher.getPublisherName())) {
			this.movieRepository.getMovieLogger().addCode("Publisher already exists");
			addMoviePublisherMiddle(movie, publisher);
		}else {
			this.movieRepository.addPublisher(publisher);
			addMoviePublisherMiddle(movie, publisher);
		}
	}
	
	public void addCast(Movie movie, MovieCast cast) {
		if(isCastAlreadyAdded(cast.getActorFirstName(), cast.getActorLastName(), cast.getNameInMovie())) {
			this.movieRepository.getMovieLogger().addCode("Cast already exists");
			addMovieCastMiddle(movie, cast);
		}else {
			this.movieRepository.addCast(cast);
			addMovieCastMiddle(movie, cast);
		}
	}
	
	public void addRater(Movie movie, MovieRater rater, double raterRating) {
		if(isRaterAlreadyAdded(rater.getRaterName())) {
			this.movieRepository.getMovieLogger().addCode("Rater already exists");
			addMovieRaterMiddle(movie, rater, raterRating);
		}else {
			this.movieRepository.addRater(rater);
			addMovieRaterMiddle(movie, rater, raterRating);
		}
	}
	
	public HashMap<String, DisplayMovie> getServiceAllDisplayMovie(){
		getAllDisplayMovie();
		return this.movieRepository.getMovieResults().getMovieDisplayResults();
	}
	
	public void getAllDisplayMovie() {
		this.movieRepository.getDisplayMovie();
	}
	
	public void getAllMovies() {
		this.movieRepository.getAllMovie();
	}
	
	public HashMap<String, Movie> getServiceAllMovies() {
		return this.movieRepository.getMovieResults().getAllMovieResults();
	}
	
	public HashMap<String, String> getServiceMovieLogger() {
		return this.movieRepository.getMovieLogger().getHashMap();
	}
	
	public HashMap<String, String> getServiceMovieGenre(String movieId) {
		getMovieGenre(movieId);
		return this.movieRepository.getMovieResults().getMovieGenre();
	}
	
	public void getMovieGenre(String movieId) {
		this.movieRepository.getMovieGenres(movieId);
	}
	
	public HashMap<String, String> getServiceMoviePublisher(String movieId) {
		getMoviePublisher(movieId);
		return this.movieRepository.getMovieResults().getMoviePublisher();
	}
	
	public void getMoviePublisher(String movieId) {
		this.movieRepository.getMoviePublishers(movieId);
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
	private void addMovieGenreMiddle(Movie movie, MovieGenre genre) {
		int movieId = getMovieId(movie.getMovieName(), movie.getMovieYear());
		int genreId = getGenreId(genre.getGenreName());
		this.movieRepository.addMovieGenreMiddle(movieId, genreId);
		System.out.println("Add Movie Genre Middle id: "+movieId+" Genre Id:"+genreId);
	}
	private void addMoviePublisherMiddle(Movie movie, MoviePublisher publisher) {
		int movieId = getMovieId(movie.getMovieName(), movie.getMovieYear());
		int publisherId = getPublisherId(publisher.getPublisherName());
		this.movieRepository.addMoviePublisherMiddle(movieId, publisherId);
		System.out.println("Add Movie Publisher Middle id: "+movieId+" Publisher Id:"+publisherId);
	}
	private void addMovieCastMiddle(Movie movie, MovieCast cast) {
		int movieId = getMovieId(movie.getMovieName(), movie.getMovieYear());
		int castId = getCastId(cast.getActorFirstName(), cast.getActorLastName(), cast.getNameInMovie());
		this.movieRepository.addMovieCastMiddle(movieId, castId);
		System.out.println("Add Movie Cast Middle id: "+movieId+" Cast Id:"+castId);
	}
	private void addMovieRaterMiddle(Movie movie, MovieRater rater, double raterRating) {
		int movieId = getMovieId(movie.getMovieName(), movie.getMovieYear());
		int raterId = getRaterId(rater.getRaterName());
		this.movieRepository.addMovieRaterMiddle(movieId, raterId, raterRating);
		System.out.println("Add Movie Rater Middle id: "+movieId+" Rater Id:"+raterId);
	}
	
	//validate
	//check if the user is already added
	private boolean isMovieUserAlreadyAdded(String userEmail) {
		if(this.movieRepository.getIdUsingOneCol("email", "movie_user", userEmail, "user_id") == -1)
			return false;
		return true;
	}
	
	//check if the movie exists
	private boolean isMovieAlreadyAdded(String movieName, String movieYear) {
		if(this.movieRepository.getIdUsingTwoCol("movie_name", "movie_year", "movie", movieName, movieYear, "movie_id") == -1)
			return false;
		return true;
	}
	//check if the genre exists	
	private boolean isGenreAlreadyAdded(String genreName) {
		if(this.movieRepository.getIdUsingOneCol("genre_name", "movie_genre", genreName, "genre_id") == -1)
			return false;
		return true;
	}
	//check if the publisher exists
	private boolean isPublisherAlreadyAdded(String publisherName) {
		if(this.movieRepository.getIdUsingOneCol("publisher_name", "movie_publisher", publisherName, "publisher_id") == -1)
			return false;
		return true;
	}
	//check if the rater exists
	private boolean isRaterAlreadyAdded(String raterName) {
		if(this.movieRepository.getIdUsingOneCol("rater_name", "movie_rater", raterName, "rater_id") == -1)
			return false;
		return true;
	}
	//check if the cast exists
	private boolean isCastAlreadyAdded(String actorFirstName, String actorLastName, String nameInMovie) {
		if(this.movieRepository.getIdUsingThreeCol("actor_first_name", "actor_last_name", "name_in_movie", "movie_cast", actorFirstName, actorLastName, nameInMovie, "cast_id") == -1)
			return false;
		return true;
	}
}//end class