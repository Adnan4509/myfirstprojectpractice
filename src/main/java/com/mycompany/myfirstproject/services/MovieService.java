package com.mycompany.myfirstproject.services;

import com.mycompany.myfirstproject.dto.MovieMapper;
import com.mycompany.myfirstproject.dto.MovieRequestDto;
import com.mycompany.myfirstproject.dto.MovieResponseDto;
import com.mycompany.myfirstproject.entity.Movie;
import com.mycompany.myfirstproject.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
