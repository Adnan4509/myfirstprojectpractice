package com.mycompany.myfirstproject.dto;

import com.mycompany.myfirstproject.entity.Movie;

public class MovieMapper {
    public static MovieResponseDto toResponseDTO(Movie movie){
    return new MovieResponseDto(
            movie.getId(),
            movie.getTitle(),
            movie.getRating(),
            movie.getDescription()
    );
    }

    public static Movie toEntity (MovieRequestDto  movieRequestDto){
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.name());
        movie.setDescription(movieRequestDto.description());

        return movie;
    }

    public static Movie toEntityUpdate (MovieUpdateDto  movieUpdateDto){
        Movie movie = new Movie();
        movie.setBoxOffice(movieUpdateDto.collection());
        movie.setRating(movieUpdateDto.rating());
        movie.setReleaseDate(movieUpdateDto.releaseDate());

        return movie;
    }
}
