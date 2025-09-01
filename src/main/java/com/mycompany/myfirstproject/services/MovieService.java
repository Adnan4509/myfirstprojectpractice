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

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepo;

    public List<MovieResponseDto> getMyMovies(){

        List<Movie> movie = movieRepo.findAll();
        List<MovieResponseDto> allMovies = new ArrayList<>();
        for(Movie mov: movie){
            MovieResponseDto responseDto = MovieMapper.toResponseDTO(mov);
            allMovies.add(responseDto);
        }
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
