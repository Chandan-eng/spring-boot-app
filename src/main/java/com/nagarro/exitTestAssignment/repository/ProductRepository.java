package com.nagarro.exitTestAssignment.repository;
import com.nagarro.exitTestAssignment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findAllByCategoryId(int id);
    // public List<Product> findAllByCategories_Id(int id);

    //Searching...
    public List<Product> findByNameContaining(String keywords);


}
