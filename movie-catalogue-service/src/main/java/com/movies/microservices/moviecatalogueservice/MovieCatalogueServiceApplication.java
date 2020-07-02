package com.movies.microservices.moviecatalogueservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogueServiceApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	public WebClient.Builder getWebClientBuilderr(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogueServiceApplication.class, args);
	}

}
