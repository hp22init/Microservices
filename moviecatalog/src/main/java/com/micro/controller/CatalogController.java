package com.micro.controller;

import com.micro.model.CatalogItems;
import com.micro.model.Movie;
import com.micro.model.Ratings;
import com.micro.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    // autowire means somboday has a bean named restTemplete somewhere inject me that
    // check if its lazy or eager initiaization
    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatalogItems> getCatalog(@PathVariable String userId) {

        //3--
        //since the its is created  inside the getCatlog method
        //so eveytime the url is hit a new resttemplete object is created
        // so we don't want that
        //we want to have one instance which is used accross the application
        // How we do that :- its done via bean in spring are by default sigletons

       // WebClient.Builder builder = WebClient.builder();


        //2--Making call for each of the movies via rest templete
        //since the rest templete method is created  inside the getCatlog method
        //so eveytime the url is hit a new resttemplete object is created
        // so we don't want that
        //we want to have one instance which is used accross the application
        // How we do that :- its done via bean in spring are by default sigletons

        //--RestTemplate restTemplate = new RestTemplate();

        // get all rated movie IDs
        UserRatings userRatings = restTemplate.getForObject("http://movie-rating-service:8083/ratings/user/" +userId, UserRatings.class);
        return userRatings.getUserRatings().stream().map(rating -> {

            //for each movie ID, call movie info service and get details
            //1--Problem # 1 the url is hardcoded, for any change in url the program will break say for port changes etc.
            // the line below is the single snippet which is making the call to API and unmarshalling the object
            // this can be done via webclient as well #-- is code for webclient which is reactive code
            Movie movies = restTemplate.getForObject("http://movie-info-service:8082/movies/" +rating.getMovieId(), Movie.class);

            //Asynchronous way
            /* Movie movies = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/movies/888")
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/

                    //put them all together
                return new CatalogItems(movies.getName(), movies.getDesc(), rating.getRating());
                })
                .collect(Collectors.toList());




    }
}
