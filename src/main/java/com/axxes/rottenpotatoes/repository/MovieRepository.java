package com.axxes.rottenpotatoes.repository;

import com.axxes.rottenpotatoes.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
