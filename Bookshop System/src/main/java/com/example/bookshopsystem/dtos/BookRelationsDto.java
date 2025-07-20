package com.example.bookshopsystem.dtos;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Category;

import java.util.List;

public class BookRelationsDto {

    private final Author author;
    private final List<Category> categories;

    public BookRelationsDto(Author author, List<Category> categories) {
        this.author = author;
        this.categories = categories;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Category> getCategories() {
        return categories;
    }
}