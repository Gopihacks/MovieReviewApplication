package com.example.movie_review.Controller;

import com.example.movie_review.Entity.MovieReview;
import com.example.movie_review.Entity.Movies;
import com.example.movie_review.Repository.movieRepo;
import com.example.movie_review.Service.movieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@CrossOrigin(
        origins = "https://m0viereviewapp.netlify.app",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class movieController {

    @Autowired
    movieService movieSer;


    @PostMapping
    public Movies addMovie(@Valid @RequestBody Movies movies) {
        return movieSer.addMovie(movies);
    }

    @GetMapping
    public List<Movies> getAllMovies() {
        return movieSer.getAllMovies();
    }

    @GetMapping("/{movieId}/stats")
    public Map<String, Object> getMovieStats(@PathVariable Integer movieId) {
        Map<String, Object> stats = new HashMap<>();
        stats.put("averageRating", movieSer.getAverageRating(movieId));
        stats.put("reviewCount", movieSer.getReviewCount(movieId));
        return stats;
    }

}
