package com.example.SBCircutBreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BooksService {

    private final RestTemplate restTemplate;

    public BooksService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String getBooks() {
        URI uri = URI.create("http://localhost:8090/books");
        return this.restTemplate.getForObject(uri, String.class);

    }

    public String reliable(){
        return "response from reliable";
    }
}
