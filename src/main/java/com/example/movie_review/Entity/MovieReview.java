package com.example.movie_review.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class MovieReview {

    public MovieReview(){}

    public MovieReview(String review, Integer rating, Movies movie) {
        this.review = review;
        this.rating = rating;
        this.movie = movie;
    }

    public MovieReview(Integer id, String review, Integer rating, Movies movie) {
        this.id = id;
        this.review = review;
        this.rating = rating;
        this.movie = movie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2,message = "Enter minimum 2 character")
    private String review;
    private Integer rating;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;
}
