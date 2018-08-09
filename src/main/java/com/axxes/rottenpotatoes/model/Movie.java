package com.axxes.rottenpotatoes.model;

import java.util.Date;
import java.util.List;

public class Movie {

    private final String id;
    private final String title;
    private final String director;
    private final Date releaseDate;
    private final List<Comment> comments;

    public Movie(final String id,
                 final String title,
                 final String director,
                 final Date releaseDate,
                 final List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int score() {
        return comments.stream().mapToInt(Comment::getScore).sum() / comments.size();
    }
}
