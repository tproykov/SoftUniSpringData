package com.example.bookshopsystem.services;

import com.example.bookshopsystem.dtos.BookInputDto;
import com.example.bookshopsystem.dtos.BookRelationsDto;
import com.example.bookshopsystem.entities.Book;

public interface BookService {

    Book create(BookInputDto inputDto, BookRelationsDto relationsDto);
}
