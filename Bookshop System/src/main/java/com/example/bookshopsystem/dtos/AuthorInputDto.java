package com.example.bookshopsystem.dtos;

public class AuthorInputDto {
    private final String firstName, lastName;

    public AuthorInputDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
