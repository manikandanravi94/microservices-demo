package com.mani.service;

import com.mani.model.MovieRatingResponse;
import com.mani.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RatingInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getRatingFallback")
    public MovieRatingResponse getRatingResponse(long id) {
        return restTemplate.getForObject("http://USER-RATING-SERVICE/movieratings?id=" + id, MovieRatingResponse.class);
    }

    public MovieRatingResponse getRatingFallback(long id) {
        return new MovieRatingResponse(Arrays.asList(new Rating(0, 0,0)));
    }
}
