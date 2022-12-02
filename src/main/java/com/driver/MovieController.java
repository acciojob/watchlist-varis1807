package com.driver;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class MovieController {

    //Creating database
    Map<Integer, Movie> moviesDb = new HashMap<>();

    //Creating Api's
//    1--> Add a movie: POST /movies/add-movie
//    Pass the Movie object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovie
    @PostMapping("/movies/add-movie")
    public void add_Movie(@RequestBody(required = true) Movie m){
        moviesDb.put(m.getId(),m);
        System.out.println();
    }
}
