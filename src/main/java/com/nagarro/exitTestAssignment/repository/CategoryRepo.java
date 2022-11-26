package com.nagarro.exitTestAssignment.repository;

import com.nagarro.exitTestAssignment.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categories,Integer> {

}

