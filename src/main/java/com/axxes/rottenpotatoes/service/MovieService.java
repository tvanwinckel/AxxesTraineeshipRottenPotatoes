package com.axxes.rottenpotatoes.service;

import com.axxes.rottenpotatoes.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovie(Long id);

    Movie addMovie(Movie movie);

    Movie updateMovie(Movie movie);

    void deleteMovie(Long movie);
}
