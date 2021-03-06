package com.movies.microservices.moviecatalogueservice.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.movies.microservices.moviecatalogueservice.model.CatalogueItem;
import com.movies.microservices.moviecatalogueservice.model.Movie;
import com.movies.microservices.moviecatalogueservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource implements Serializable {

	// @Autowired
	// private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GetMapping("/movie/{userId}")
	@HystrixCommand(fallbackMethod = "getFallBackCatalog")
	public List<CatalogueItem> getCatalog(@PathVariable("userId") String userId) {

		// RestTemplate restTemplate = new RestTemplate();
		// WebClient.Builder builder=WebClient.builder();

		UserRating userRatings = webClientBuilder.build().get().uri("http://movie-rating-service/ratingdata/users/foo")
				.retrieve().bodyToMono(UserRating.class).block();

		// List<Rating> listRatings = Arrays.asList(new Rating("1232", 5), new
		// Rating("1233", 4), new Rating("1234", 3),
		// new Rating("1235", 2), new Rating("1236", 1));

		return userRatings.getUsreRatings().stream().map(rating -> {
			// Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" +
			// rating.getMovieId(), Movie.class);MOVIE-INFO-SERVICE

			Movie movie = webClientBuilder.build().get().uri("http://movie-info-service/movies/" + rating.getMovieId())
					.retrieve().bodyToMono(Movie.class).block();
			return new CatalogueItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());

		// get all related movies

		// for each movie ID,call movie info service and get details

		// combine all together

		// List<CatalogueItem> listMovies=Arrays.asList(
		// new CatalogueItem("Transformers", "test", 4)
		// );
		// return listMovies;
	}
	
	public List<CatalogueItem> getFallBackCatalog(@PathVariable("userId") String userId) {

		return Arrays.asList(new CatalogueItem("no movie", "no movie", 0));


	}


}
