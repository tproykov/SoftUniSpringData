package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Book;

public interface BookService {

    Book createBook(BookInputDto inputDto);
}
