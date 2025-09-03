package com.mycompany.myfirstproject.dto;

import java.time.LocalDate;

public record MovieUpdateDto(
        LocalDate releaseDate,
        double rating,
        double collection
) {
}
