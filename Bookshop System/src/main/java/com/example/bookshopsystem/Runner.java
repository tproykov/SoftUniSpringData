package com.example.bookshopsystem;

import com.example.bookshopsystem.dtos.AuthorInputDto;
import com.example.bookshopsystem.dtos.CategoryInputDto;
import com.example.bookshopsystem.services.AuthorService;
import com.example.bookshopsystem.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;

    public Runner(CategoryService categoryService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<String> categoryLines = readSeedFiles("categories.txt");
        for (String line : categoryLines) {
            CategoryInputDto inputDto = new CategoryInputDto(line);
            categoryService.create(inputDto);
        }

        List<String> authorLines = readSeedFiles("authors.txt");
        for (String line : authorLines) {
            String[] tokens = line.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];

            AuthorInputDto inputDto = new AuthorInputDto(firstName, lastName);
            authorService.create(inputDto);
        }

        List<String> booksData = readSeedFiles("books.txt");



        // 2. Prepare repository files + services for seeds and queries
    }

    private List<String> readSeedFiles(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource(filename);

        try (InputStream inputStream = resource.getInputStream()) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader.lines().toList();
        }
    }

}
