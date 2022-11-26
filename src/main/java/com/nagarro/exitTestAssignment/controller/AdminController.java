package com.nagarro.exitTestAssignment.controller;
import com.nagarro.exitTestAssignment.dto.ProductDto;
import com.nagarro.exitTestAssignment.model.Categories;
import com.nagarro.exitTestAssignment.model.Product;
import com.nagarro.exitTestAssignment.services.CategoryService;
import com.nagarro.exitTestAssignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public String displayProduct(){
        return "adminHome";
    }
    @GetMapping("/home")
    public String homePage(){
        return "index";
    }

    @GetMapping("/admin/categories")
    public String categories(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category",new Categories());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Categories categories){

       categoryService.addCategory(categories);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model){
        Optional<Categories> categoriesOptional=categoryService.getCategoryById(id);
        if(categoriesOptional.isPresent()){
            model.addAttribute("category",categoriesOptional.get());
            return "categoriesAdd";
        }
        return "404";
    }

    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products",productService.getAllProduct());
        return "products";
    }






    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDto",new ProductDto());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "productsAdd";

    }

    @PostMapping("/admin/products/add")
    public String addProducts(@ModelAttribute("productDto")ProductDto productdto, @RequestParam("productImage") MultipartFile file
                              ,@RequestParam("imgName")String imgName) throws IOException {
        Product product=new Product();
        product.setId(productdto.getId());
        product.setName(productdto.getName());
        product.setPrice(productdto.getPrice());
        product.setRating(productdto.getRating());
        product.setBrand(productdto.getBrand());
        product.setDescription(productdto.getDescription());
        product.setCategory(categoryService.getCategoryById(productdto.getCategoryId()).get());
        String imgUUID;
        if(!file.isEmpty()){
            imgUUID=file.getOriginalFilename();
            Path fileNameAndPath= Paths.get(uploadDir,imgUUID);
            Files.write(fileNameAndPath,file.getBytes());
        }
        else{
            imgUUID=imgName;
        }
        product.setImageName(imgUUID);
        productService.addProducts(product);
        System.out.println(product);
        return "redirect:/admin/products";

    }

    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.deleteProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/update/{id}")
   public String updateProductGet(@PathVariable long id,Model model){

        Product product=productService.getProductById(id).get();
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setDescription(product.getDescription());
        productDto.setRating(product.getRating());
        productDto.setImageName(product.getImageName());

        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("productDto",productDto);
        return "productsAdd";
   }

}
