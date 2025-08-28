package com.mycompany.myfirstproject.services;

import com.mycompany.myfirstproject.entity.Movie;
import com.mycompany.myfirstproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public List<Movie> getMyMovies(){

        return movieRepo.findAll();

    }

   public Movie getMovieFromId(Long id){
        return movieRepo.findById(id).orElseThrow();

    }

    public Movie createMovie(Movie movieObj){
        return movieRepo.save(movieObj);

    }

    public void deleteFromId(Long id){
        movieRepo.deleteById(id);
    }


}
