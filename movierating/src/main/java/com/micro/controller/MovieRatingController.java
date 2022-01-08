package com.micro.controller;

import com.micro.models.Ratings;
import com.micro.models.UserRatings;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class MovieRatingController {

    @GetMapping(value= "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ratings getMovieRating(@PathVariable String movieId){

        return new Ratings(movieId, 3);
    }

    @GetMapping(value= "user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRatings getUserRating(@PathVariable String userId){
        List<Ratings> ratings = Arrays.asList(
                new Ratings("1234", 4),
                new Ratings("9989", 3)
        );
        UserRatings userRatings = new UserRatings(ratings);
        return userRatings;
    }
}
