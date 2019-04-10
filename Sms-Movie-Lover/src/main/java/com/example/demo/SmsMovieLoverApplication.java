package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movie.comtroller.MovieController;


@SpringBootApplication
public class SmsMovieLoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsMovieLoverApplication.class, args);
		MovieController controller = new MovieController();
		String movieName = "Focus";
		String movieYear = "2019";
		double raterRating = 7.3;
		controller.addMovie(movieName, movieYear);
		controller.addGenre(movieName, movieYear, "Comedy");
		controller.addCast(movieName, movieYear, "Bruce", "Willis", "John");
		controller.addPublisher(movieName, movieYear, "Warner Bros");
		controller.addRater(movieName, movieYear, "Rotten Tomatoes", raterRating);
	}
}//end class