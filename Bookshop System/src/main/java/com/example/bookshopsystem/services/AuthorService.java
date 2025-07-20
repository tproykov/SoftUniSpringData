package com.example.bookshopsystem.services;

import com.example.bookshopsystem.dtos.AuthorInputDto;
import com.example.bookshopsystem.entities.Author;

public interface AuthorService {

    Author create(AuthorInputDto inputDto);
}
