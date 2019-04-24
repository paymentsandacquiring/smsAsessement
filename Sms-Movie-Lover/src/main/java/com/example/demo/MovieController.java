package com.example.demo;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.databasefactory.MovieLogger;
import com.movie.model.DisplayMovie;
import com.movie.repository.MovieRepository;
import com.movie.repository.MovieResults;
import com.movie.service.MovieService;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(path="/movie")
public class MovieController {
	private MovieService movieService;
	
	public MovieController() {
		this(new MovieService(new MovieRepository(new MovieLogger(), new MovieResults())));
	}
	
	public MovieController(MovieLogger movieLogger, MovieResults movieResults) {
		this(new MovieService(movieLogger, movieResults));
	}
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	
	@GetMapping(path="/getAllMovieWatched")
	public @ResponseBody  HashMap<String, DisplayMovie> getAllMovieWatched() {
		
		
//		HashMap<String, String> hashMap = new HashMap<>();
//		HashMap<String, String> hashMap2 = new HashMap<>();
//		this.movieService.getMovieGenre("1");
////		hashMap = this.movieService.getServiceMovieGenre();
//		hashMap.put("movieName", "Ant Man 2");
//		hashMap.put("movieYear", "2018");
//		hashMap.put("movieGenre", "Action, Comedy");
//		hashMap.put("moviePublisher", "Marvel Studios");
//		hashMap2.put("movieName", "Avengers");
//		hashMap2.put("movieYear", "2019");
//		hashMap2.put("movieGenre", "Action, Comedy, Romance");
//		hashMap2.put("moviePublisher", "Marvel Studios, DC Universe");
		HashMap<String, DisplayMovie> results = new HashMap<>();
		results = this.movieService.getServiceAllDisplayMovie();
//		results.put("results", hashMap);
//		results.put("results2", hashMap2);
		return results;
	}
	
	@GetMapping(path= "/addMovieUser")
	public @ResponseBody HashMap<String, String> addUser(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String gender, @RequestParam String password){
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap = this.movieService.getServiceMovieLogger();
		this.movieService.addMovieUser(new MovieUser(0,firstName, lastName, gender, email, password));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/addMovie")
	public @ResponseBody HashMap<String, String> addMovie(@RequestParam String movieName, @RequestParam String movieYear) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap = this.movieService.getServiceMovieLogger();
		this.movieService.addMovie(new Movie(0,movieName,movieYear));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "addGenre")
	public @ResponseBody HashMap<String, String> addGenre(@RequestParam String movieName, @RequestParam String movieYear, @RequestParam String genreName) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap = this.movieService.getServiceMovieLogger();
		this.movieService.addGenre(new Movie(0,movieName,movieYear), new MovieGenre(0,genreName));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/addPublisher")
	public @ResponseBody HashMap<String, String> addPublisher(@RequestParam String movieName, @RequestParam String movieYear, @RequestParam String publisherName) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap = this.movieService.getServiceMovieLogger();
		this.movieService.addPublisher(new Movie(0,movieName,movieYear), new MoviePublisher(0,publisherName));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/addCast")
	public @ResponseBody HashMap<String, String> addCast(@RequestParam String movieName, @RequestParam String movieYear, @RequestParam String actorFirstName, @RequestParam String actorLastName, @RequestParam String nameInMovie) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap = this.movieService.getServiceMovieLogger();
		this.movieService.addCast(new Movie(0,movieName,movieYear), new MovieCast(0,actorFirstName,actorLastName,nameInMovie));
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/addRater")
	public @ResponseBody HashMap<String, String> addRater(@RequestParam String movieName, @RequestParam String movieYear, @RequestParam String raterName, @RequestParam double raterRating) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap = this.movieService.getServiceMovieLogger();
		this.movieService.addRater(new Movie(0,movieName,movieYear), new MovieRater(0,raterName), raterRating);
		System.err.println(hashMap);
		
		return hashMap;
	}
	
	@GetMapping(path = "/allMovies")
	public @ResponseBody HashMap<String, Movie> getAllMovies(){
		HashMap<String, Movie> hashMap = new HashMap<>();
		this.movieService.getAllMovies();
		hashMap = this.movieService.getServiceAllMovies();
		System.err.println(hashMap);
		return hashMap;
	}
}//end class