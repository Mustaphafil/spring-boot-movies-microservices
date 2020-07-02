package com.movies.microservices.moviecatalogueservice.controller;

import java.io.Serializable;
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
	public List<CatalogueItem> getCatalog(@PathVariable("userId") String userId) {

		// RestTemplate restTemplate = new RestTemplate();
		// WebClient.Builder builder=WebClient.builder();

		UserRating userRatings = webClientBuilder.build().get().uri("http://localhost:8083/ratingdata/users/foo")
				.retrieve().bodyToMono(UserRating.class).block();

		// List<Rating> listRatings = Arrays.asList(new Rating("1232", 5), new
		// Rating("1233", 4), new Rating("1234", 3),
		// new Rating("1235", 2), new Rating("1236", 1));

		return userRatings.getUsreRatings().stream().map(rating -> {
			// Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" +
			// rating.getMovieId(), Movie.class);

			Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/" + rating.getMovieId())
					.retrieve().bodyToMono(Movie.class).block();
			return new CatalogueItem(movie.getName(), "DESC", rating.getRating());
		}).collect(Collectors.toList());

		// get all related movies

		// for each movie ID,call movie info service and get details

		// combine all together

		// List<CatalogueItem> listMovies=Arrays.asList(
		// new CatalogueItem("Transformers", "test", 4)
		// );
		// return listMovies;
	}

}
