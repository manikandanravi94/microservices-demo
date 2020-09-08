package com.mani.model;

public class Rating {

    private long movieId;

    private int rating;

    private long userId;

    public Rating(long movieId, int rating, long userId) {
        this.movieId = movieId;
        this.rating = rating;
        this.userId = userId;
    }

    public Rating() {
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
