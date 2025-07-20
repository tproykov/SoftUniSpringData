package com.example.bookshopsystem.dtos;

import com.example.bookshopsystem.enums.EditionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookInputDto {
    private final String title;
    private final BigDecimal price;
    private final Integer copies;
    private final EditionType editionType;
    private final LocalDate releaseDate;


}
