package com.axxes.rottenpotatoes.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String text;
    private String author;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Comment() {
        // Required by jpa
    }

    public Comment(final String text,
                   final String author,
                   final int score) {
        this.text = text;
        this.author = author;
        this.score = score;
    }

    public Long getCommentId() {
        return commentId;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public int getScore() {
        return score;
    }
}
