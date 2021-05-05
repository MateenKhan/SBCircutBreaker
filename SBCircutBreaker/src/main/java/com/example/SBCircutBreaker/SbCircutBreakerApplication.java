package com.example.SBCircutBreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class SbCircutBreakerApplication {

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	BooksService booksService;

	@GetMapping("/books")
	public String getBooks(){
		return booksService.getBooks();
	}

	public static void main(String[] args) {
		SpringApplication.run(SbCircutBreakerApplication.class, args);
	}



}
