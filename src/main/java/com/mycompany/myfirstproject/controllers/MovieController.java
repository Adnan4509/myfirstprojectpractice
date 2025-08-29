package com.mycompany.myfirstproject.controllers;

import com.mycompany.myfirstproject.dto.MovieReponseDto;
import com.mycompany.myfirstproject.entity.Movie;
import com.mycompany.myfirstproject.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//localhost:8080           /api/movies
@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController{

    private final MovieService movieService;


    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies =  movieService.getMyMovies();
        return ResponseEntity.ok(movies);
    }






    @GetMapping("/{id}")
    public ResponseEntity<MovieReponseDto> getSpecificMovie1(@PathVariable Long id){

        MovieReponseDto retrivedMovie = movieService.getMovieFromId(id);

        return ResponseEntity.ok(retrivedMovie);
    }




    @PostMapping
    public ResponseEntity<Movie> createNewMovie(@RequestBody MovieReponseDto body){
        //some processing
        Movie movie = movieService.createMovie(body);

        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecificMovie(@PathVariable long id){

        System.out.println("trying to delete movie");
        movieService.deleteFromId(id);

        System.out.println("movie deleted successfully");
    }
}

