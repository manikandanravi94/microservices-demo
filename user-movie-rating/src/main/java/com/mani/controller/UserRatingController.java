package com.mani.controller;

import com.mani.model.Movie;
import com.mani.model.MovieRatingResponse;
import com.mani.model.RatedMovie;
import com.mani.model.Rating;
import com.mani.service.MovieInfoService;
import com.mani.service.RatingInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserRatingController {

    @Autowired
    private RatingInfoService ratingInfoService;

    @Autowired
    private MovieInfoService movieInfoService;


    @GetMapping
    public List<RatedMovie> getUserMovieRating(@RequestParam("id") long id) {
        MovieRatingResponse rating = ratingInfoService.getRatingResponse(id);
        List<RatedMovie> ratedMovieList=rating.getRatingList().stream().
                map(rating1 ->  movieInfoService.getMovie(rating1)).collect(Collectors.toList());
        System.out.println("Entered user movie Controller" +rating);
        return ratedMovieList;
    }







}
