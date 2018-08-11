package com.axxes.rottenpotatoes.controller;

import com.axxes.rottenpotatoes.model.Movie;
import com.axxes.rottenpotatoes.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public void getAllMovies() {
        final List<Movie> movies = movieService.getAllMovies();
    }
}
