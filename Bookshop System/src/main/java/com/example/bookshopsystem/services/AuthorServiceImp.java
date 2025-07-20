package com.example.bookshopsystem.services;

import com.example.bookshopsystem.dtos.AuthorInputDto;
import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImp implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(AuthorInputDto inputDto) {
        Author author = new Author();
        author.setFirstName(inputDto.getFirstName());
        author.setLastName(inputDto.getLastName());

        return authorRepository.save(author);
    }
}
