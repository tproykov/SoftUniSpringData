package com.example.bookshopsystem.dtos;

import com.example.bookshopsystem.enums.AgeRestriction;
import com.example.bookshopsystem.enums.EditionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookInputDto {
    private final String title;
    private final BigDecimal price;
    private final Long copies;
    private final EditionType editionType;
    private final LocalDate releaseDate;
    private final AgeRestriction ageRestriction;


    public BookInputDto(String title, BigDecimal price, Long copies,
                        EditionType editionType, LocalDate releaseDate,
                        AgeRestriction ageRestriction) {
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.editionType = editionType;
        this.releaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getCopies() {
        return copies;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }
}
