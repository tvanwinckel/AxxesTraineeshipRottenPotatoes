package com.axxes.rottenpotatoes.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;
    private String title;
    private String director;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movie")
    private List<Comment> comments;


    public Movie() {
        // Required by jpa
    }

    public Movie(final String title,
                 final String director,
                 final Date releaseDate) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(final String director) {
        this.director = director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getScore() {
        try {
            return comments.stream().mapToInt(Comment::getScore).sum() / comments.size();
        } catch (final Exception e) {
            return 0;
        }
    }
}
