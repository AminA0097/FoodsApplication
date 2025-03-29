package com.springsecurity.foods.Category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryInterface{
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public CategoryEntity findCategory(long id) throws Exception {
        return categoryRepo.findId(id);
    }
}
