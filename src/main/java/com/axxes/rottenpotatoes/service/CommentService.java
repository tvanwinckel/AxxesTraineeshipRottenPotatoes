package com.axxes.rottenpotatoes.service;

import com.axxes.rottenpotatoes.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentsForMovie(Long movieId);

    Comment getComment(Long id);

    Comment addComment(Comment comment);

    Comment updateComment(Comment comment);

    void delete(Long commentId);

}
