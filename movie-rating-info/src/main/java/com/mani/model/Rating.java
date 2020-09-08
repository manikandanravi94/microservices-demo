package com.mani.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rating {

    private long movieId;

    private int rating;

    private long userId;

    public Rating(long movieId, int rating, long userId) {
        this.movieId = movieId;
        this.rating = rating;
        this.userId = userId;
    }
}
