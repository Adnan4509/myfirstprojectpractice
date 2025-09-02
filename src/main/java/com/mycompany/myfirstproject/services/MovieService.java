package com.mycompany.myfirstproject.services;

import com.mycompany.myfirstproject.dto.MovieMapper;
import com.mycompany.myfirstproject.dto.MovieRequestDto;
import com.mycompany.myfirstproject.dto.MovieResponseDto;
import com.mycompany.myfirstproject.entity.Movie;
import com.mycompany.myfirstproject.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepo;

    public List<MovieResponseDto> getMyMovies(){

        List<Movie> movie = movieRepo.findAll();
        List<MovieResponseDto> allMovies = movie.stream().map(MovieMapper::toResponseDTO).collect(Collectors.toList());

        return allMovies;

    }

   public MovieResponseDto getMovieFromId(Long id){
        Movie movie = movieRepo.findById(id).orElseThrow();
        return MovieMapper.toResponseDTO(movie);

    }

    public MovieResponseDto createMovie(MovieRequestDto movieObj){
        Movie newMovie = MovieMapper.toEntity(movieObj);
        movieRepo.save(newMovie);
        return MovieMapper.toResponseDTO(newMovie);

    }

    public void deleteFromId(Long id){
        movieRepo.deleteById(id);
    }


}
