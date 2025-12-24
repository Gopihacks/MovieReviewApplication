package com.example.movie_review.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Movies {

    public Movies(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2, message = "MovieName must be at least 2 characters")
    private String movieName;

    @NotBlank
    @Size(min = 5, message = "Gener must be at least 5 characters")
    private String genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Movies(Integer id, String movieName, String genre) {
        this.id = id;
        this.movieName = movieName;
        this.genre = genre;
    }

    public Movies(String movieName, String genre) {
        this.movieName = movieName;
        this.genre = genre;
    }

}
