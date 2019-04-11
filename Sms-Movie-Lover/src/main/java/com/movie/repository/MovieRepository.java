package com.movie.repository;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.databasefactory.DatabaseFactory;
import com.example.databasefactory.MovieLogger;
import com.example.demo.Movie;
import com.example.demo.MovieCast;
import com.example.demo.MovieGenre;
import com.example.demo.MoviePublisher;
import com.example.demo.MovieRater;

public class MovieRepository {
	private Connection connection = null;
	private MovieLogger movieLogger;
	private MovieResults movieResults;
	
	public MovieRepository(MovieLogger movieLogger, MovieResults movieResults) {
		this.connection = DatabaseFactory.getConnection();
		this.movieLogger = movieLogger;
		this.movieResults = movieResults;
	}//end default 
	
	public void addMovie(Movie movie) {
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "INSERT INTO movie(movie_name, movie_year) VALUES('"+movie.getMovieName()+"','"+movie.getMovieYear()+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("Movie");
			this.movieLogger.addCode(!saved?"Saved":"Error saving data!");			
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating movie table " + sql.getMessage());
		}//end catch
	}
	
	public void addGenre(MovieGenre genre) {
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "INSERT INTO movie_genre(genre_name) VALUES('"+genre.getGenreName()+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("Genre");
			this.movieLogger.addCode(!saved?"Saved":"Error saving data!");			
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating genre table " + sql.getMessage());
		}//end catch
	}
	
	public void addPublisher(MoviePublisher publisher) {
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "INSERT INTO movie_publisher(publisher_name) VALUES('"+publisher.getPublisherName()+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("Publisher");
			this.movieLogger.addCode(!saved?"Saved":"Error saving data!");			
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating publisher table " + sql.getMessage());
		}//end catch
	}
	
	public void addCast(MovieCast cast) {
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "INSERT INTO movie_cast(actor_first_name, actor_last_name, name_in_movie) VALUES('"+cast.getActorFirstName()+"','"+cast.getActorLastName()+"','"+cast.getNameInMovie()+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("Cast");
			this.movieLogger.addCode(!saved?"Saved":"Error saving data!");			
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating cast table " + sql.getMessage());
		}//end catch
	}
	
	public void addRater(MovieRater rater) {
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "INSERT INTO movie_rater(rater_name) VALUES('"+rater.getRaterName()+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("Rater");
			this.movieLogger.addCode(!saved?"Saved":"Error saving data!");			
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating rater table " + sql.getMessage());
		}//end catch
	}
	
	public void addMovieGenreMiddle(int movieId, int genreId){
		try {
			Statement statement = this.connection.createStatement();
			String query = "INSERT INTO movie_genre_middle(movie_id, genre_id) VALUES('"+movieId+"','"+genreId+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("movie_genre_middle");
			this.movieLogger.addMessage("code_middle", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating movie_genre_middle table " + sql.getMessage());
			this.movieLogger.addMessage("Info", "Please ensure the movie is added");
		}
	}
	
	public void addMoviePublisherMiddle(int movieId, int publisherId){
		try {
			Statement statement = this.connection.createStatement();
			String query = "INSERT INTO movie_publisher_middle(movie_id, publisher_id) VALUES('"+movieId+"','"+publisherId+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("movie_publisher_middle");
			this.movieLogger.addMessage("code_middle", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating movie_publisher_middle table " + sql.getMessage());
			this.movieLogger.addMessage("Info", "Please ensure the movie is added");
		}
	}
	
	public void addMovieCastMiddle(int movieId, int castId){
		try {
			Statement statement = this.connection.createStatement();
			String query = "INSERT INTO movie_cast_middle(movie_id, cast_id) VALUES('"+movieId+"','"+castId+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("movie_cast_middle");
			this.movieLogger.addMessage("code_middle", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating movie_cast_middle table " + sql.getMessage());
			this.movieLogger.addMessage("Info", "Please ensure the movie is added");
		}
	}
	
	public void addMovieRaterMiddle(int movieId, int raterId, double raterRating){
		try {
			Statement statement = this.connection.createStatement();
			String query = "INSERT INTO movie_rater_middle(movie_id, rater_id, rater_rating) VALUES('"+movieId+"','"+raterId+"','"+raterRating+"')";
			
			boolean saved = statement.execute(query);
			
			this.movieLogger.addTable("movie_rater_middle");
			this.movieLogger.addMessage("code_middle", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating movie_rater_middle table " + sql.getMessage());
			this.movieLogger.addMessage("Info", "Please ensure the movie is added");
		}
	}
	
	//methods to get details from database
	public void getAllMovie() {
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "SELECT * FROM movie";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				String movieId = resultSet.getString("movie_id");
				String movieName = resultSet.getString("movie_name");
				String movieYear = resultSet.getString("movie_year");
				
				Movie movie = new Movie(Integer.parseInt(movieId), movieName, movieYear);
				this.movieResults.setAllMovieResults(movie);
			}			
			this.movieLogger.addTable("Movie");
			this.movieLogger.addCode(!(resultSet != null)?"Success":"Error retrievng data!");			
		}catch(SQLException sql) {
			this.movieLogger.addEXCEPTION("Error updating movie table " + sql.getMessage());
		}//end catch
	}
	
 	public int getIdUsingTwoCol(String columnName1, String columnName2, String tableName, String criteria1, String criteria2, String idColumnName) {
		int id = -1 ;
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "SELECT * FROM "+tableName+" WHERE "+columnName1+"='"+criteria1+"' AND "+columnName2+"='"+criteria2+"'";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				id = Integer.parseInt(resultSet.getString(idColumnName));
			}
		}catch(SQLException sql) {
			
		}
		return id;
	}
	
	public int getIdUsingOneCol(String columnName, String tableName, String criteria, String idColumnName) {
		int id = -1;
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "SELECT * FROM "+tableName+" WHERE "+columnName+"='"+criteria+"'";
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				id = Integer.parseInt(resultSet.getString(idColumnName));
			}
		}catch(SQLException sql) {
			
		}
		return id;
	}
	
	public int getIdUsingThreeCol(String columnName1, String columnName2, String columnName3, String tableName, String criteria1, String criteria2, String criteria3, String idColumnName) {
		int id = -1;
		try {
			Statement statement = this.connection.createStatement();
			
			String query = "SELECT * FROM "+tableName+" WHERE "+columnName1+"='"+criteria1+"' AND "+columnName2+"='"+criteria2+"' AND "+columnName3+"='"+criteria3+"'";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				id = Integer.parseInt(resultSet.getString(idColumnName));
			}
		}catch(SQLException sql) {
			
		}
		return id;
	}
	
	public MovieLogger getMovieLogger() {
		return this.movieLogger;
	}
	
	public MovieResults getMovieResults(){
		return this.movieResults;
	}
}//end class