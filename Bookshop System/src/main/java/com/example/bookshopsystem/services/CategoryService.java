package com.example.bookshopsystem.services;

import com.example.bookshopsystem.dtos.CategoryInputDto;
import com.example.bookshopsystem.entities.Category;

public interface CategoryService {
    Category create(CategoryInputDto inputDto);
}
