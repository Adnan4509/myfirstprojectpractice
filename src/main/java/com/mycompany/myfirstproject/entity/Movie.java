package com.mycompany.myfirstproject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic details
    @NotNull
    @NotEmpty
    private String title;

    private String description;
    private String language;
    private String country;

    // Dates & Duration
    private LocalDate releaseDate;
    private int durationMinutes;   // movie length in minutes

    // Ratings & Popularity
    private double rating;         // e.g., IMDb rating
    private int voteCount;         // number of votes/reviews
    private double boxOffice;      // worldwide gross collection

    // Crew & Cast
    private String director;
    private String writer;
    private String productionCompany;

    // Classification
    private String genre;          // e.g., Action, Comedy
    private String certificate;    // e.g., PG-13, R

    // Extra info
    private String posterUrl;
    private String trailerUrl;
    private boolean isAvailableOnStreaming; // e.g., Netflix/Prime

}
