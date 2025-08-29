package com.mycompany.myfirstproject.services;

import com.mycompany.myfirstproject.dto.MovieMapper;
import com.mycompany.myfirstproject.dto.MovieReponseDto;
import com.mycompany.myfirstproject.dto.PostMapper;
import com.mycompany.myfirstproject.entity.Movie;
import com.mycompany.myfirstproject.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepo;

    public List<Movie> getMyMovies(){
//
       return movieRepo.findAll();
//        List<Movie> movie = movieRepo.findAll();
//        List<MovieReponseDto>  dtoList = MovieMapper.toDTO(movie);
//        return null;

    }

   public MovieReponseDto getMovieFromId(Long id){
        Movie movie = movieRepo.findById(id).orElseThrow();
        return MovieMapper.toDTO(movie);

    }

    public MovieReponseDto createMovie(MovieReponseDto movieObj){
        Movie newMovie = PostMapper.DtoTo(movieObj);

       Movie savedMovie = movieRepo.save(newMovie);
       MovieReponseDto returnMovie = MovieMapper.toDTO(savedMovie);

         return returnMovie;

    }

    public void deleteFromId(Long id){
        movieRepo.deleteById(id);
    }


}
