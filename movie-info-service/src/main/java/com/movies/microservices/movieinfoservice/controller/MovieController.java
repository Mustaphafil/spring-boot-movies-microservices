package com.movies.microservices.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.microservices.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	
	
	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable(name = "movieId")String movieId) {
		return new Movie(movieId, "TestName");
	}

}
