package com.example.bookshopsystem.services;

import com.example.bookshopsystem.dtos.BookInputDto;
import com.example.bookshopsystem.dtos.BookRelationsDto;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(BookInputDto inputDto, BookRelationsDto relationsDto) {
        Book book = new Book();
        book.setTitle(inputDto.getTitle());
        book.setAgeRestriction(inputDto.getAgeRestriction());
        book.setEditionType(inputDto.getEditionType());
        book.setPrice(inputDto.getPrice());
        book.setReleaseDate(inputDto.getReleaseDate());
        book.setCopies(inputDto.getCopies());

        book.setAuthor(relationsDto.getAuthor());
        book.setCategories(Set.copyOf(relationsDto.getCategories()));

        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBookReleasedAfter(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        return bookRepository.findAllByReleaseDateGreaterThanEqual(date);
    }
}