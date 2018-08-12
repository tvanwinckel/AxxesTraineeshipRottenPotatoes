package com.axxes.rottenpotatoes.controller;

import com.axxes.rottenpotatoes.model.Movie;
import com.axxes.rottenpotatoes.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ModelAndView getAllMovies() {
        final List<Movie> movies = movieService.getAllMovies();
        final ModelAndView view = new ModelAndView("allMoviesView");
        view.addObject("movies", movies);
        return view;
    }

    @GetMapping("/movies/{id}")
    public ModelAndView getMovie(@PathVariable(name = "id") final Long id) {
        final Movie movie = movieService.getMovie(id);
        final ModelAndView view = new ModelAndView("singleMovieView");
        view.addObject("movie", movie);
        return view;
    }

    @GetMapping("/movie")
    public ModelAndView addMovieForm() {
        final ModelAndView view = new ModelAndView("addMovieView");
        view.addObject("movie", new Movie());
        return view;
    }

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView addMovieSubmit(@ModelAttribute final Movie movie) {
        movieService.addMovie(movie);
        return getAllMovies();
    }

    @PutMapping("/movie")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ModelAndView updateMovieForm(@RequestParam(name = "id", required = true) final Long id) {
        final Movie movie = movieService.getMovie(id);
        final ModelAndView view = new ModelAndView("updateMovieView");
        view.addObject("movie", movie);
        return view;
    }

    @PostMapping("/movie-update")
    public ModelAndView updateMovieSubmit(@ModelAttribute final Movie movie) {
        movieService.updateMovie(movie);
        return getAllMovies();
    }

    @DeleteMapping("/movie")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ModelAndView deleteMovie(@RequestParam(name="id", required=true) final Long id) {
        movieService.deleteMovie(id);
        return getAllMovies();
    }
}
