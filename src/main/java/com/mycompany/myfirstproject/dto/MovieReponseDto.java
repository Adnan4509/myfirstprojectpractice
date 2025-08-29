package com.mycompany.myfirstproject.dto;


import com.mycompany.myfirstproject.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieReponseDto {
    private Long id;
    private String name;
    private double stars;
    private String information;
}
