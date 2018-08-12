package com.axxes.rottenpotatoes.controller;

import com.axxes.rottenpotatoes.model.Comment;
import com.axxes.rottenpotatoes.model.CommentDto;
import com.axxes.rottenpotatoes.model.Movie;
import com.axxes.rottenpotatoes.service.CommentService;
import com.axxes.rottenpotatoes.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;
    private final MovieService movieService;

    @Autowired
    public CommentController(final CommentService commentService,
                             final MovieService movieService) {
        this.commentService = commentService;
        this.movieService = movieService;
    }

    @GetMapping("/movie/{movieId}/comments")
    private ModelAndView getAllComments(@PathVariable(name = "movieId") final Long movieId) {
        final List<Comment> comments = commentService.getAllCommentsForMovie(movieId);
        final ModelAndView view = new ModelAndView("allCommentsForMovie");
        view.addObject("comments", comments);
        return view;
    }

    @GetMapping("/comment/{id}")
    public ModelAndView getComment(@PathVariable(name = "id") final Long id) {
        final Comment comment = commentService.getComment(id);
        final ModelAndView view = new ModelAndView("singleCommentView");
        view.addObject("comment", comment);
        return view;
    }

    @GetMapping("/movie/{movieId}/comment")
    public ModelAndView addCommentForm(@PathVariable(name = "movieId") final Long movieId) {
        final ModelAndView view = new ModelAndView("addCommentView");
//        FIXME : Transaction problem because we give an object instead of objectId
//        final Movie movie = movieService.getMovie(movieId);
//        final Comment comment = new Comment();
//        comment.setMovie(movie);
        view.addObject("movieId", movieId);
        view.addObject("commentDto", new CommentDto());
        return view;
    }

    @PostMapping("/comment")
    public ModelAndView addCommentSubmit(@RequestParam("movieId") final Long movieId,
                                         @ModelAttribute final CommentDto commentDto) {
        final Movie movie = movieService.getMovie(movieId);
        final Comment comment = new Comment(commentDto.getText(), commentDto.getAuthor(), commentDto.getScore(), movie);
        commentService.addComment(comment);
        movie.addComment(comment);

        return getAllComments(comment.getMovie().getMovieId());
    }

}
