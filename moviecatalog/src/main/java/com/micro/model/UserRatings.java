package com.micro.model;

import java.util.List;

public class UserRatings {

    private List<Ratings> userRatings;

    public UserRatings() {
    }

    public UserRatings(List<Ratings> userRatings) {
        this.userRatings = userRatings;
    }

    public List<Ratings> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Ratings> userRatings) {
        this.userRatings = userRatings;
    }

}
