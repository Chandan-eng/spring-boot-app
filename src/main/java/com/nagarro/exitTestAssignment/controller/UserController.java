package com.nagarro.exitTestAssignment.controller;
import com.nagarro.exitTestAssignment.model.Categories;
import com.nagarro.exitTestAssignment.model.Product;
import com.nagarro.exitTestAssignment.services.CategoryService;
import com.nagarro.exitTestAssignment.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

//@Controller
@RestController
public class UserController {

    private final CategoryService categoryService;

    private final ProductService productService;

    public UserController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }


    @CrossOrigin("http://localhost:4200")
    @GetMapping("/products")
    public ResponseEntity<List<Product>>  getAllProducts(){
        List<Product> products=productService.getAllProduct();
        System.out.println(products);
        return  ResponseEntity.ok(products);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/categories")
    public ResponseEntity<List<Categories>>  getAllCategories(){


        List<Categories> categories=categoryService.getAllCategories();

        return  ResponseEntity.ok(categories);
    }

    //Find product by product Id

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id).get();

    }
//Find product By Category Id
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/productsbycategories/{id}")
    public ResponseEntity<List<Product>> findAllByCategoryId(@PathVariable int id){
        List<Product> products=productService.findAllByCategoryId(id);
        return ResponseEntity.ok(products);

    }
//Tesing.......
//    @GetMapping("/shop/categories/{id}")
//    public String shopByCategories(Model model, @PathVariable int id) {
//
//        model.addAttribute("category",categoryService.getCategoryById(id));
//        model.addAttribute("products",productService.getAllProductsByCategoryId(id));
//        return "shop";
//    }

    //Search Product By Name/keyword
    @GetMapping("/search/{query}")
      public ResponseEntity<List<Product>> search(@PathVariable("query") String query, Principal principal ){
        System.out.println(query);
        List<Product> products=productService.findByNameContaining(query);
        return ResponseEntity.ok(products);
}
}