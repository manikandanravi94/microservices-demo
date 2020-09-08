package com.mani.controller;


import com.mani.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private static List<Movie> movies = Arrays.asList(new Movie(123,"master","Vijay's movie"),
            new Movie(234,"kkk","robbery movie"),
            new Movie(456,"omg","love story"));

    @Value("${api_key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping
    public Movie getMovies(@RequestParam("id") long id){
        return movies.stream().filter(movie ->movie.getId()==id).findAny().get();
    }
}
