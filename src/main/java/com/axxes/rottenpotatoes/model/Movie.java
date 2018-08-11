package com.axxes.rottenpotatoes.model;

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

    public String getDirector() {
        return director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

//    public int score() {
//        return comments.stream().mapToInt(Comment::getScore).sum() / comments.size();
//    }
}
