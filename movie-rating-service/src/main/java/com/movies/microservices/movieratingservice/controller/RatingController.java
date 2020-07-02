package com.movies.microservices.movieratingservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.microservices.movieratingservice.model.Rating;
import com.movies.microservices.movieratingservice.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingController {

	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String movieId) {
		List<Rating> ratings = Arrays.asList(new Rating("1232", 5), new Rating("1233", 4), new Rating("1234", 3),
				new Rating("1235", 2), new Rating("1236", 1));
		UserRating userRatings = new UserRating();
		userRatings.setUsreRatings(ratings);
		return userRatings;
	}

}
