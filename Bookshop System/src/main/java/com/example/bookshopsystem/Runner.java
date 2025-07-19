package com.example.bookshopsystem;

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

    @Override
    public void run(String... args) throws Exception {
        List<String> categories = readSeedFiles("categories.txt");
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
