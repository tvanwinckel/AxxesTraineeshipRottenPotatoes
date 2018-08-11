package com.axxes.rottenpotatoes.service;

import com.axxes.rottenpotatoes.model.Movie;
import com.axxes.rottenpotatoes.repository.CommentRepository;
import com.axxes.rottenpotatoes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public MovieServiceImpl(final MovieRepository movieRepository,
                            final CommentRepository commentRepository) {
        this.movieRepository = movieRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(final Long id) {
        final Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            return optionalMovie.get();
        } else {
            throw new MovieNotFoundException();
        }
    }

    @Override
    public Movie addMovie(final Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(final Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(final Long id) {
        final Movie movie = getMovie(id);
        movie.getComments().forEach(commentRepository::delete);
        movieRepository.delete(movie);
    }
}
