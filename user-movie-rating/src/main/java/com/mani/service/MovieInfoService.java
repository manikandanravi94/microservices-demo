package com.mani.service;

import com.mani.model.Movie;
import com.mani.model.RatedMovie;
import com.mani.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;
//we can add the commands externally according to our need like we can configure 1. last failed count list
    //and how much is acceptable in it etc..
    // commandProperties =    { @HystrixProperty(name=”execution.isolation.thread.timeoutInMilliSeconds”, value=”500”)
    //"execution.isolatio.thread.timeoutinmilliseconds",value="2000"
    //circuitBreaker.requestVolumeThreshold value="5"
    //circuitBreaker.errorThresholdPercentage value-"50"
    //circuitBreaker.sleepWindowinMilliSeconds value="5000"



    @HystrixCommand(fallbackMethod = "getMovieFallback")
    public RatedMovie getMovie(Rating rating1) {
        Movie movie= restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie?id="+ rating1.getMovieId(), Movie.class);
        return new RatedMovie(movie.getId(), rating1.getRating(),movie.getName(),movie.getType());
    }

    public RatedMovie getMovieFallback(Rating rating1) {
        return new RatedMovie(rating1.getMovieId(),rating1.getRating(),"No movie","No type");
    }
}
