package com.movies.microservices.movieratingservice.model;

import java.io.Serializable;
import java.util.List;

public class UserRating {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
