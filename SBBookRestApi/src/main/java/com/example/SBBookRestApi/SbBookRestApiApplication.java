package com.example.SBBookRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbBookRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbBookRestApiApplication.class, args);
	}


	@GetMapping("/books")
	public String getBooks(){
		return "getting books from Books Application";
	}


}
