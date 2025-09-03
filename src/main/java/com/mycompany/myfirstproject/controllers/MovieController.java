package com.mycompany.myfirstproject.controllers;

import com.mycompany.myfirstproject.dto.MovieRequestDto;
import com.mycompany.myfirstproject.dto.MovieResponseDto;
import com.mycompany.myfirstproject.dto.MovieUpdateDto;
import com.mycompany.myfirstproject.entity.Movie;
import com.mycompany.myfirstproject.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//localhost:8080           /api/movies
@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController{

    private final MovieService movieService;


    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(){
        List<MovieResponseDto> movies =  movieService.getMyMovies();
        return ResponseEntity.ok(movies);
    }






    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> getSpecificMovie1(@PathVariable Long id){

        MovieResponseDto retrivedMovie = movieService.getMovieFromId(id);

        return ResponseEntity.ok(retrivedMovie);
    }




    @PostMapping
    public ResponseEntity<MovieResponseDto> createNewMovie(@RequestBody MovieRequestDto body){
        //some processing
        MovieResponseDto savedMovie = movieService.createMovie(body);

        return ResponseEntity.ok(savedMovie);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecificMovie(@PathVariable long id){

        System.out.println("trying to delete movie");
        movieService.deleteFromId(id);

        System.out.println("movie deleted successfully");
    }

    @PatchMapping("/{id}")
    public MovieResponseDto changeMovie(@PathVariable long id, @RequestBody MovieUpdateDto body){
       return movieService.changeInfo(id, body);
    }
}

