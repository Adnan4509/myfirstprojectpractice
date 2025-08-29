package com.mycompany.myfirstproject.dto;

import com.mycompany.myfirstproject.entity.Movie;

public class MovieMapper {
    public static MovieReponseDto toDTO(Movie movie){
        MovieReponseDto dto = new MovieReponseDto();
        dto.setId(movie.getId());
        dto.setName(movie.getTitle());
        dto.setStars(movie.getRating());

        return dto;
    }

}
