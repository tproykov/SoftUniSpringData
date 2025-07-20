package com.example.bookshopsystem.services;

import com.example.bookshopsystem.dtos.CategoryInputDto;
import com.example.bookshopsystem.entities.Category;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(CategoryInputDto inputDto) {
        Category category = new Category();
        category.setName(inputDto.getName());

        return categoryRepository.save(category);
    }
}