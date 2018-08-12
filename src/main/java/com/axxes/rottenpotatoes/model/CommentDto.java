package com.axxes.rottenpotatoes.model;

public class CommentDto {

    private Long movieId;
    private String text;
    private String author;
    private int score;

    public CommentDto() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(final Long movieId) {
        this.movieId = movieId;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public int getScore() {
        return score;
    }

    public void setScore(final int score) {
        this.score = score;
    }
}
