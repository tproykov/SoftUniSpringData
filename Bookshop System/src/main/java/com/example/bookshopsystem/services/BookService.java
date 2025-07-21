package com.example.bookshopsystem.services;

import com.example.bookshopsystem.dtos.BookInputDto;
import com.example.bookshopsystem.dtos.BookRelationsDto;
import com.example.bookshopsystem.entities.Book;

import java.util.List;

public interface BookService {

    Book create(BookInputDto inputDto, BookRelationsDto relationsDto);

    List<Book> findBookReleasedAfter(int year);
}
