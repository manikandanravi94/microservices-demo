package com.mani.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class RatedMovie {
    private long movieId;
    private long rating;
    private String movieName;
    private String movieDescription;

    public RatedMovie(long movieId, long rating, String movieName, String movieDescription) {
        this.movieId = movieId;
        this.rating = rating;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
    }
}
