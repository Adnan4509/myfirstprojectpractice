package com.mycompany.myfirstproject.dto;

import com.mycompany.myfirstproject.entity.Movie;

public class PostMapper {
    public static Movie DtoTo(MovieReponseDto postDto){
        Movie movie = new Movie();
        movie.setId(postDto.getId());
        movie.setTitle(postDto.getName());
        movie.setDescription(postDto.getInformation());

        return movie;
    }
}
