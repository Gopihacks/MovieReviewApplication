package com.example.movie_review.Service;

import com.example.movie_review.Entity.Movies;
import com.example.movie_review.Repository.movieRepo;
import com.example.movie_review.Repository.movieReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieService {
    @Autowired
    movieRepo movierepo;

    @Autowired
    movieReviewRepo moviereviewRepo;

    public Movies addMovie(Movies movie) {
        return movierepo.save(movie);
    }

    public List<Movies> getAllMovies() {
        return movierepo.findAll();
    }

    public Double getAverageRating(Integer movieId) {
        return moviereviewRepo.findAverageRatingByMovieId(movieId);
    }

    public Long getReviewCount(Integer movieId) {
        return moviereviewRepo.countByMovieId(movieId);
    }

}
