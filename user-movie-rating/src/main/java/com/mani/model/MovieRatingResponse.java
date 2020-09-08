package com.mani.model;

import java.util.List;



public class MovieRatingResponse {



    private List<Rating> ratingList;

    public MovieRatingResponse() {
    }

    public MovieRatingResponse(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
