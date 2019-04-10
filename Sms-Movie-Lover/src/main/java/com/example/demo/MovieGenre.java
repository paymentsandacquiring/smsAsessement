package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieGenre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genreId", updatable = false, nullable = false)
	private int genreId;
	private String genreName;
	
	public MovieGenre(int genreId, String genreName) {
		this.genreId = genreId;
		this.genreName = genreName;
	}//end primary constructor
	
	public MovieGenre() {
		this.genreId = 0;
		this.genreName = "";
	}//end default constructor

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}	
}//end class