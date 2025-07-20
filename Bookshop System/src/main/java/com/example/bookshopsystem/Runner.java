package com.example.bookshopsystem;

import com.example.bookshopsystem.dtos.AuthorInputDto;
import com.example.bookshopsystem.dtos.CategoryInputDto;
import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.entities.Category;
import com.example.bookshopsystem.enums.AgeRestriction;
import com.example.bookshopsystem.enums.EditionType;
import com.example.bookshopsystem.services.AuthorService;
import com.example.bookshopsystem.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
        List<Category> categories = new ArrayList<>();
        for (String line : categoryLines) {
            CategoryInputDto inputDto = new CategoryInputDto(line);
            Category currentCategory = categoryService.create(inputDto);
            categories.add(currentCategory);
        }

        List<String> authorLines = readSeedFiles("authors.txt");
        List<Author> authors = new ArrayList<>();
        for (String line : authorLines) {
            String[] tokens = line.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];

            AuthorInputDto inputDto = new AuthorInputDto(firstName, lastName);
            Author currentAuthor = authorService.create(inputDto);
            authors.add(currentAuthor);
        }

        List<String> bookLines = readSeedFiles("books.txt");
        String[] data = null;
        for (String line : bookLines) {
            data = line.split("\\s+");
        }

        EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
        LocalDate releaseDate = LocalDate.parse(data[1],
                DateTimeFormatter.ofPattern("d/M/yyyy"));
        Long copies = Long.parseLong(data[2]);
        BigDecimal price = new BigDecimal(data[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(data[4])];
        String title = Arrays.stream(data)
                .skip(5)
                .collect(Collectors.joining(" "));

        int randomAuthorIndex = ThreadLocalRandom.current().nextInt(0, authors.size());
        Author author = authors.get(randomAuthorIndex);

        int randomCategoriesCount = ThreadLocalRandom.current().nextInt(0, 3);
        List<Category> relevantCategories = new ArrayList<>();
        for (int i = 0; i < randomCategoriesCount; i++) {
            int randomCategoryIndex = ThreadLocalRandom.current().nextInt(0, categories.size());
            relevantCategories.add(categories.get(randomCategoryIndex));
        }



    }

    // 2. Prepare repository files + services for seeds and queries

    private List<String> readSeedFiles(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource(filename);

        try (InputStream inputStream = resource.getInputStream()) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader.lines().toList();
        }
    }

}
