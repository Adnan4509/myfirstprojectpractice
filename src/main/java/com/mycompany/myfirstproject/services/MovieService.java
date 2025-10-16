package com.mycompany.myfirstproject.services;

import com.mycompany.myfirstproject.dto.MovieMapper;
import com.mycompany.myfirstproject.dto.MovieRequestDto;
import com.mycompany.myfirstproject.dto.MovieResponseDto;
import com.mycompany.myfirstproject.dto.MovieUpdateDto;
import com.mycompany.myfirstproject.entity.Movie;
import com.mycompany.myfirstproject.kafka.NotificationProducer;
import com.mycompany.myfirstproject.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepo;
    private final NotificationProducer notificationProducer;

//    public List<MovieResponseDto> getMyMovies(){
//
//        List<Movie> movie = movieRepo.findAll();
//        List<MovieResponseDto> allMovies = movie.stream().map(MovieMapper::toResponseDTO).collect(Collectors.toList());
//
//        return allMovies;
//
//    }

    public Page<MovieResponseDto> getMyMovies(int pageNumber, int pageSize, long rating){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Movie> moviesPage;
        if(rating != 0){
            moviesPage = movieRepo.findByRatingGreaterThan(rating, pageable);
        }else{
            moviesPage = movieRepo.findAll(pageable);
        }

        Page<MovieResponseDto>  moviesDto = moviesPage.map(MovieMapper::toResponseDTO);
        return moviesDto;
    }

   public MovieResponseDto getMovieFromId(Long id){
        Movie movie = movieRepo.findById(id).orElseThrow();
        return MovieMapper.toResponseDTO(movie);

    }

    public String createMovie(MovieRequestDto movieObj){

        notificationProducer.sendMovie(movieObj);


        return "Saving movie through kafka";
    }

    public void deleteFromId(Long id){
        movieRepo.deleteById(id);
    }


    public MovieResponseDto changeInfo(long id, MovieUpdateDto body) {
        Movie movie = movieRepo.findById(id).orElseThrow();
        Movie newMovie = MovieMapper.toEntityUpdate(body);
        if(newMovie.getRating() != 0){
            movie.setRating(newMovie.getRating());
        }
        if(newMovie.getReleaseDate() != null){
            movie.setReleaseDate(newMovie.getReleaseDate());
        }
        if(newMovie.getBoxOffice() != 0){
            movie.setBoxOffice(newMovie.getBoxOffice());
        }
        Movie changedMovie = movieRepo.save(movie);

        return MovieMapper.toResponseDTO(changedMovie);
    }

    public MovieResponseDto createMovieById(long id, MovieRequestDto body) {
        Movie movie = movieRepo.findById(id).orElseThrow();
        Movie newMovie= MovieMapper.toEntity(body);
        newMovie.setId(movie.getId());
        Movie createNewMovie = movieRepo.save(newMovie);
        return MovieMapper.toResponseDTO(createNewMovie);

    }
}
