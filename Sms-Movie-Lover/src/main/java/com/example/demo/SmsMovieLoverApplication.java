package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 import com.movie.comtroller.MovieController;


@SpringBootApplication
public class SmsMovieLoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsMovieLoverApplication.class, args);
		MovieController controller = new MovieController();
		String movieName = "Cars";
		String movieYear = "2017";
		double raterRating = 7.5;
		controller.addMovie(movieName, movieYear);
		controller.addGenre(movieName, movieYear, "Comedy");
		controller.addGenre(movieName, movieYear, "Action");
		controller.addCast(movieName, movieYear, "Tom", "Cruise", "Car");
		controller.addPublisher(movieName, movieYear, "Disney");
		controller.addRater(movieName, movieYear, "IMDB", raterRating);
	}
}//end class