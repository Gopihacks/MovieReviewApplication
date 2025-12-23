package com.example.movie_review.Repository;

import com.example.movie_review.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movieRepo extends JpaRepository<Movies,Integer> {
}
