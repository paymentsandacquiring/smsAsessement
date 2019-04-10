package com.movie.comtroller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Movie;
import com.example.demo.MovieCast;
import com.example.demo.MovieGenre;
import com.example.demo.MoviePublisher;
import com.example.demo.MovieRater;
import com.movie.service.MovieService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/movie")
public class MovieController {
	private MovieService movieService;
	
	public MovieController() {
		this.movieService = new MovieService();
	}
	
	@GetMapping(path = "/addMovie")
	public @ResponseBody HashMap<String, String> addMovie(@RequestParam String movieName, @RequestParam String movieYear) {
		HashMap<String, String> hashMap = new HashMap<>();
		
		hashMap =  movieService.addMovie(new Movie(0,movieName,movieYear));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/addGenre")
	public @ResponseBody HashMap<String, String> addGenre(@RequestParam String movieName, @RequestParam String movieYear, @RequestParam String genreName) {
		HashMap<String, String> hashMap = new HashMap<>();
		
		hashMap = movieService.addGenre(new Movie(0,movieName,movieYear), new MovieGenre(0,genreName));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/addPublisher")
	public @ResponseBody HashMap<String, String> addPublisher(@RequestParam String movieName, @RequestParam String movieYear, @RequestParam String publisherName) {
		HashMap<String, String> hashMap = new HashMap<>();
		
		hashMap = movieService.addPublisher(new Movie(0,movieName,movieYear), new MoviePublisher(0,publisherName));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/addCast")
	public @ResponseBody HashMap<String, String> addCast(@RequestParam String movieName, @RequestParam String movieYear, @RequestParam String actorFirstName, @RequestParam String actorLastName, @RequestParam String nameInMovie) {
		HashMap<String, String> hashMap = new HashMap<>();
		
		hashMap = movieService.addCast(new Movie(0,movieName,movieYear), new MovieCast(0,actorFirstName,actorLastName,nameInMovie));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/addRater")
	public @ResponseBody HashMap<String, String> addRater(@RequestParam String movieName, @RequestParam String movieYear, @RequestParam String raterName, @RequestParam double raterRating) {
		HashMap<String, String> hashMap = new HashMap<>();
		
		hashMap = movieService.addRater(new Movie(0,movieName,movieYear), new MovieRater(0,raterName), raterRating);
		System.err.println(hashMap);
		
		return hashMap;
	}
}//end class