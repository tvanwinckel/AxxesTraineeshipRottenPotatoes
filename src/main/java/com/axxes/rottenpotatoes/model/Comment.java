package com.axxes.rottenpotatoes.model;

public class Comment {

    private final String text;
    private final String author;
    private final int score;

    public Comment(final String text,
                   final String author,
                   final int score) {
        this.text = text;
        this.author = author;
        this.score = score;
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
