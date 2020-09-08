package com.mani.controller;

import com.mani.model.MovieRatingResponse;
import com.mani.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieRatingController {

    private static List<Rating> ratingList = Arrays.asList(new Rating(123, 4,1),
            new Rating(234, 3,1),new Rating(345, 1,2),new Rating(456, 5,1));

    @GetMapping("movieratings")
    public MovieRatingResponse getMovieRatings(long id){
        MovieRatingResponse response = new MovieRatingResponse();
                response.setRatingList(ratingList.stream().filter(rating -> rating.getUserId()==id).collect(Collectors.toList()));
                return response;
    }
}
