package com.axxes.rottenpotatoes.controller;

import com.axxes.rottenpotatoes.model.Comment;
import com.axxes.rottenpotatoes.model.Movie;
import com.axxes.rottenpotatoes.service.CommentService;
import com.axxes.rottenpotatoes.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        final Movie movie = movieService.getMovie(movieId);
        final Comment comment = new Comment();
        comment.setMovie(movie);
        view.addObject("comment", comment);
        return view;
    }

    @PostMapping("/comment")
    public ModelAndView addCommentSubmit(@ModelAttribute final Comment comment) {
        commentService.addComment(comment);
        return getAllComments(comment.getMovie().getMovieId());
    }

    @PutMapping("/comment")
    public ModelAndView updateComment(@RequestParam(name = "id", required = true) final Long id) {
        final Comment comment = commentService.getComment(id);
        final ModelAndView view = new ModelAndView("updateCommentView");
        view.addObject("comment", comment);
        return view;
    }

    @PostMapping("/movie/{movieId}/comment-update")
    public ModelAndView updateCommentSubmit(@PathVariable(name = "movieId") final Long movieId,
                                            @ModelAttribute final Comment comment) {
        commentService.updateComment(comment);
        return getAllComments(movieId);
    }

    @DeleteMapping("/movie/{movieId}/comment")
    public ModelAndView deleteComment(@PathVariable(name = "movieId") final Long movieId,
                                      @RequestParam(name = "id", required = true) final Long commentId) {
        commentService.delete(commentId);
        return getAllComments(movieId);
    }
}
