package com.example.movie_review.Controller;

import com.example.movie_review.Entity.MovieReview;
import com.example.movie_review.Service.movieReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class movieReviewController {

        @Autowired
        private movieReviewService reviewService;

        @PostMapping("/{movieId}/reviews")
        public MovieReview addReview(
                @PathVariable Integer movieId,
                @RequestBody MovieReview review) {
            return reviewService.addReview(movieId, review);
        }

        @GetMapping("/{movieId}/reviews")
        public List<MovieReview> getReviews(@PathVariable Integer movieId) {
            return reviewService.getReviewsByMovie(movieId);
        }
    }


