package com.example.bookshopsystem;

import com.example.bookshopsystem.dtos.AuthorInputDto;
import com.example.bookshopsystem.dtos.BookInputDto;
import com.example.bookshopsystem.dtos.BookRelationsDto;
import com.example.bookshopsystem.dtos.CategoryInputDto;
import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.entities.Category;
import com.example.bookshopsystem.enums.AgeRestriction;
import com.example.bookshopsystem.enums.EditionType;
import com.example.bookshopsystem.services.AuthorService;
import com.example.bookshopsystem.services.BookService;
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
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private BookService bookService;

    public Runner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Category> categories = seedCategories();

        List<Author> authors = seedAuthors();

        seedBooks(authors, categories);

        // First query
        List<Book> books = bookService.findBookReleasedAfter(2000);
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    private List<Category> seedCategories() throws IOException {
        List<String> categoryLines = readSeedFiles("categories.txt");
        List<Category> categories = new ArrayList<>();
        for (String line : categoryLines) {
            CategoryInputDto inputDto = new CategoryInputDto(line);
            Category currentCategory = categoryService.create(inputDto);
            categories.add(currentCategory);
        }
        return categories;
    }

    private List<Author> seedAuthors() throws IOException {
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
        return authors;
    }

    private void seedBooks(List<Author> authors, List<Category> categories) throws IOException {
        List<String> bookLines = readSeedFiles("books.txt");
        for (String line : bookLines) {
            String[] data = line.split("\\s+");

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            Long copies = Long.parseLong(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            String title = Arrays.stream(data).skip(5).collect(Collectors.joining(" "));

            Author author = authors.get(ThreadLocalRandom.current().nextInt(authors.size()));

            int randomCategoriesCount = ThreadLocalRandom.current().nextInt(1, 4);
            List<Category> relevantCategories = new ArrayList<>();
            while (relevantCategories.size() < randomCategoriesCount) {
                Category category = categories.get(ThreadLocalRandom.current().nextInt(categories.size()));
                if (!relevantCategories.contains(category)) {
                    relevantCategories.add(category);
                }
            }

            BookInputDto bookInputDto = new BookInputDto(title, price, copies, editionType, releaseDate, ageRestriction);
            BookRelationsDto relationsDto = new BookRelationsDto(author, relevantCategories);
            bookService.create(bookInputDto, relationsDto);
        }
    }

    private List<String> readSeedFiles(String fileName) throws IOException {
        InputStream inputStream = new ClassPathResource(fileName).getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().collect(Collectors.toList());
    }
}
