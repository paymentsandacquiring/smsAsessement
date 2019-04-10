package com.movie.repository;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.example.databasefactory.DatabaseFactory;
import com.example.demo.Movie;
import com.example.demo.MovieCast;
import com.example.demo.MovieGenre;
import com.example.demo.MoviePublisher;
import com.example.demo.MovieRater;

public class MovieRepository {
	private static Connection connection = null;
	
	public MovieRepository() {
		MovieRepository.connection = new DatabaseFactory().getConnection();
	}//end default 
	
	public HashMap<String, String> addMovie(Movie movie) {
		HashMap<String, String> hashMap = new HashMap<>();		
		
		try {
			Statement statement = MovieRepository.connection.createStatement();
			
			String query = "INSERT INTO movie(movie_name, movie_year) VALUES('"+movie.getMovieName()+"','"+movie.getMovieYear()+"')";
			
			boolean saved = statement.execute(query);
			hashMap.put("table", "Movie");
			hashMap.put("code", !saved?"Saved":"Error saving data!");			
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating movie table " + sql.getMessage());
		}//end catch
		return hashMap;
	}
	
	public HashMap<String, String> addGenre(MovieGenre genre) {
		
		HashMap<String, String> hashMap = new HashMap<>();
		
		try {
			Statement statement = MovieRepository.connection.createStatement();
			
			String query = "INSERT INTO movie_genre(genre_name) VALUES('"+genre.getGenreName()+"')";
			
			boolean saved = statement.execute(query);
			
			hashMap.put("table", "genre");
			hashMap.put("code", !saved?"Saved":"Error saving data!");	
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating genre table " + sql.getMessage());
		}//end catch
		return hashMap;
	}
	
	public HashMap<String, String> addPublisher(MoviePublisher publisher) {
		
		HashMap<String, String> hashMap = new HashMap<>();
		
		try {
			Statement statement = MovieRepository.connection.createStatement();
			
			String query = "INSERT INTO movie_publisher(publisher_name) VALUES('"+publisher.getPublisherName()+"')";
			
			boolean saved = statement.execute(query);
			
			hashMap.put("table", "publisher");
			hashMap.put("code", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating publisher table " + sql.getMessage());
		}//end catch
		return hashMap;
	}
	
	public HashMap<String, String> addCast(MovieCast cast) {
		
		HashMap<String, String> hashMap = new HashMap<>();
		
		try {
			Statement statement = MovieRepository.connection.createStatement();
			
			String query = "INSERT INTO movie_cast(actor_first_name, actor_last_name, name_in_movie) VALUES('"+cast.getActorFirstName()+"','"+cast.getActorLastName()+"','"+cast.getNameInMovie()+"')";
			
			boolean saved = statement.execute(query);
			hashMap.put("table", "cast");
			hashMap.put("code", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating cast table " + sql.getMessage());
		}//end catch
		return hashMap;
	}
	
	public HashMap<String, String> addRater(MovieRater rater) {
		HashMap<String, String> hashMap = new HashMap<>();
		
		try {
			Statement statement = MovieRepository.connection.createStatement();
			
			String query = "INSERT INTO movie_rater(rater_name) VALUES('"+rater.getRaterName()+"')";
			
			boolean saved = statement.execute(query);
			
			hashMap.put("table", "rater");
			hashMap.put("code", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating movie table " + sql.getMessage());
		}//end catch
		return hashMap;
	}
	
	public HashMap<String, String> addMovieGenreMiddle(int movieId, int genreId){
		HashMap<String, String> hashMap = new HashMap<>();
		try {
			Statement statement = MovieRepository.connection.createStatement();
			String query = "INSERT INTO movie_genre_middle(movie_id, genre_id) VALUES('"+movieId+"','"+genreId+"')";
			
			boolean saved = statement.execute(query);
			
			hashMap.put("table_middle", "movie_genre_middle");
			hashMap.put("code_middle", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating movie_genre_middle table " + sql.getMessage());
			hashMap.put("Info", "Please ensure the movie is added");
		}
		return hashMap;
	}
	
	public HashMap<String, String> addMoviePublisherMiddle(int movieId, int publisherId){
		HashMap<String, String> hashMap = new HashMap<>();
		try {
			Statement statement = MovieRepository.connection.createStatement();
			String query = "INSERT INTO movie_publisher_middle(movie_id, publisher_id) VALUES('"+movieId+"','"+publisherId+"')";
			
			boolean saved = statement.execute(query);
			
			hashMap.put("table_middle", "movie_publisher_middle");
			hashMap.put("code_middle", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating movie_publisher_middle table " + sql.getMessage());
			hashMap.put("Info", "Please ensure the movie is added");
		}
		return hashMap;
	}
	
	public HashMap<String, String> addMovieCastMiddle(int movieId, int castId){
		HashMap<String, String> hashMap = new HashMap<>();
		try {
			Statement statement = MovieRepository.connection.createStatement();
			String query = "INSERT INTO movie_cast_middle(movie_id, cast_id) VALUES('"+movieId+"','"+castId+"')";
			
			boolean saved = statement.execute(query);
			
			hashMap.put("table", "movie_cast_middle");
			hashMap.put("code", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating movie_cast_middle table " + sql.getMessage());
			hashMap.put("Info", "Please ensure the movie is added");
		}
		return hashMap;
	}
	
	public HashMap<String, String> addMovieRaterMiddle(int movieId, int raterId, double raterRating){
		HashMap<String, String> hashMap = new HashMap<>();
		try {
			Statement statement = MovieRepository.connection.createStatement();
			String query = "INSERT INTO movie_rater_middle(movie_id, rater_id, rater_rating) VALUES('"+movieId+"','"+raterId+"','"+raterRating+"')";
			
			boolean saved = statement.execute(query);
			
			hashMap.put("table", "movie_rater_middle");
			hashMap.put("code", !saved?"Saved":"Error saving data!");
		}catch(SQLException sql) {
			hashMap.put("sqlException", "Error updating movie_rater_middle table " + sql.getMessage());
			hashMap.put("Info", "Please ensure the movie is added");
		}
		return hashMap;
	}
	
	
	public int getIdUsingTwoCol(String columnName1, String columnName2, String tableName, String criteria1, String criteria2, String idColumnName) {
		int id = -1 ;
		try {
			Statement statement = MovieRepository.connection.createStatement();
			
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
			Statement statement = MovieRepository.connection.createStatement();
			
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
			Statement statement = MovieRepository.connection.createStatement();
			
			String query = "SELECT * FROM "+tableName+" WHERE "+columnName1+"='"+criteria1+"' AND "+columnName2+"='"+criteria2+"' AND "+columnName3+"='"+criteria3+"'";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				id = Integer.parseInt(resultSet.getString(idColumnName));
			}
		}catch(SQLException sql) {
			
		}
		return id;
	}
}//end class