package com.nagarro.exitTestAssignment.serviceImp;

import com.nagarro.exitTestAssignment.model.Categories;
import com.nagarro.exitTestAssignment.repository.CategoryRepo;
import com.nagarro.exitTestAssignment.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryServiceImp(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void addCategory(Categories categories) {

        categoryRepo.save(categories);
    }

    @Override
    public void removeCategoryById(int id) {

        categoryRepo.deleteById(id);

    }

    @Override
    public Optional<Categories> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }



}
