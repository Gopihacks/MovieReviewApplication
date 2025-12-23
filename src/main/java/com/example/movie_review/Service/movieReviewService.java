package com.example.movie_review.Service;

import com.example.movie_review.Entity.MovieReview;
import com.example.movie_review.Entity.Movies;
import com.example.movie_review.Repository.movieRepo;
import com.example.movie_review.Repository.movieReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieReviewService {

    @Autowired
    private movieReviewRepo moviereviewRepo;

    @Autowired
    private movieRepo movieRepo;

    public MovieReview addReview(Integer movieId, MovieReview review) {
        Movies movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        review.setMovie(movie);
        return moviereviewRepo.save(review);
    }

    public List<MovieReview> getReviewsByMovie(Integer movieId) {
        return moviereviewRepo.findByMovieId(movieId);
    }
}
