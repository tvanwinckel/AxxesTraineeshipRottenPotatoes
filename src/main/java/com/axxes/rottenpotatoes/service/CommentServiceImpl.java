package com.axxes.rottenpotatoes.service;

import com.axxes.rottenpotatoes.model.Comment;
import com.axxes.rottenpotatoes.model.Movie;
import com.axxes.rottenpotatoes.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final MovieService movieService;

    @Autowired
    public CommentServiceImpl(final CommentRepository commentRepository,
                              final MovieService movieService) {
        this.commentRepository = commentRepository;
        this.movieService = movieService;
    }

    @Override
    public List<Comment> getAllCommentsForMovie(final Long movieId) {
        final Movie movie = movieService.getMovie(movieId);
        return movie.getComments();
    }

    @Override
    public Comment getComment(final Long id) {
        final Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            return optionalComment.get();
        } else {
            throw new CommentNotFoundException();
        }
    }

    @Override
    public Comment addComment(final Comment comment) {
        return commentRepository.save(comment);
    }
}
