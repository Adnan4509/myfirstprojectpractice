package com.mycompany.myfirstproject.dto;

public record MovieResponseDto(
        long id,
        String name,
        double rating,
        String description
) {
}