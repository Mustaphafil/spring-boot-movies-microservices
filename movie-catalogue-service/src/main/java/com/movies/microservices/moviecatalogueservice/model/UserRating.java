package com.movies.microservices.moviecatalogueservice.model;

import java.util.List;

public class UserRating {

	private List<Rating> userRatings;

	public UserRating(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}

	public UserRating() {
		super();
	}

	public List<Rating> getUsreRatings() {
		return userRatings;
	}

	public void setUsreRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	
	
	 
	
	
	
	

}
