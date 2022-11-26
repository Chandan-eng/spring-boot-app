package com.nagarro.exitTestAssignment.services;
import com.nagarro.exitTestAssignment.model.Categories;

import java.util.List;
import java.util.Optional;

//@Service
public interface CategoryService {
    //@Autowired
   // CategoryRepo categoryRepo;

//    public List<Categories> getAllCategories(){
//        return categoryRepo.findAll();
//    }
//
//    public void addCategory(Categories categories){
//        categoryRepo.save(categories);
//    }
//
//    public void removeCategoryById(int id){
//        categoryRepo.deleteById(id);
//    }
//
//    public Optional<Categories> getCategoryById(int id){
//        return categoryRepo.findById(id);
//    }
    public List<Categories> getAllCategories();
    public void addCategory(Categories categories);
    public void removeCategoryById(int id);
    public Optional<Categories> getCategoryById(int id);
}
