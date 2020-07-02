package com.movies.microservices.moviecatalogueservice.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.microservices.moviecatalogueservice.model.CatalogueItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@GetMapping("/movie/{userId}")
	public List<CatalogueItem> getCatalog(@PathVariable("userId")String userId){
		List<CatalogueItem> listMovies=Arrays.asList(
			new CatalogueItem("Transformers", "test", 4)
		);
		return  listMovies;
	}
	

}
