package com.example.bookshopsystem.dtos;

public class CategoryInputDto {
    private final String name;

    public CategoryInputDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
