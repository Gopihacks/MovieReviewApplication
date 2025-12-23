package com.example.movie_review.Repository;

import com.example.movie_review.Entity.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface movieReviewRepo extends JpaRepository<MovieReview, Integer> {
        List<MovieReview> findByMovieId(Integer movieId);

    @Query("SELECT COALESCE(AVG(r.rating), 0) " +
            "FROM MovieReview r " +
            "WHERE r.movie.id = :movieId")
    Double findAverageRatingByMovieId(Integer movieId);

    @Query("SELECT COUNT(r) " +
            "FROM MovieReview r " +
            "WHERE r.movie.id = :movieId")
    Long countByMovieId(Integer movieId);

}


