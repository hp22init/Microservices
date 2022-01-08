package com.micro.controller;

import com.micro.model.Movie;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @GetMapping(value="{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieInfo(@PathVariable String movieId){

        return new Movie(movieId, "Transformer","SciFi");
    }
}
