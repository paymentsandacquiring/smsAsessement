package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieCast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "castId", updatable = false, nullable = false)
	private int castId;
	private String actorFirstName;
	private String actorLastName;
	private String nameInMovie;
	
	public MovieCast() {
		this.actorFirstName = this.actorLastName = this.nameInMovie = "";
		this.castId = 0;
	}//end default constructor
	
	public MovieCast(int castId, String actorFirstName, String actorLastName, String nameInMovie) {
		this.castId = castId;
		this.actorFirstName = actorFirstName;
		this.actorLastName = actorLastName;
		this.nameInMovie = nameInMovie;
	}//end primary constructor

	public int getCastId() {
		return castId;
	}

	public void setCastId(int castId) {
		this.castId = castId;
	}

	public String getActorFirstName() {
		return actorFirstName;
	}

	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}

	public String getActorLastName() {
		return actorLastName;
	}

	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}

	public String getNameInMovie() {
		return nameInMovie;
	}

	public void setNameInMovie(String nameInMovie) {
		this.nameInMovie = nameInMovie;
	}
}
