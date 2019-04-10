package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieRater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "raterId", updatable = false, nullable = false)
	private int raterId;
	private String raterName;
	
	public MovieRater() {
		this.raterId = 0;
		this.raterName ="";
	}//end default constructor
	
	public MovieRater(int raterId, String raterName) {
		this.raterId = raterId;
		this.raterName = raterName;
	}//end primary constructor

	public int getRaterId() {
		return raterId;
	}

	public void setRaterId(int raterId) {
		this.raterId = raterId;
	}

	public String getRaterName() {
		return raterName;
	}

	public void setRaterName(String raterName) {
		this.raterName = raterName;
	}	
}//end class