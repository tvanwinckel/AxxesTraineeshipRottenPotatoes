package com.axxes.rottenpotatoes.service;

import com.axxes.rottenpotatoes.model.Movie;
import com.axxes.rottenpotatoes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(final String id) {
        return null;
    }

    @Override
    public Movie addMovie(final Movie movie) {
        return null;
    }

    @Override
    public Movie updateMovie(final Movie movie) {
        return null;
    }

    @Override
    public void deleteMovie(final Movie movie) {

    }
}
