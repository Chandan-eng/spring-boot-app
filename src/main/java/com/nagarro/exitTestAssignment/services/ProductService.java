package com.nagarro.exitTestAssignment.services;
import com.nagarro.exitTestAssignment.model.Product;
import com.nagarro.exitTestAssignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//@Service
public interface ProductService {

//   private final ProductRepository productRepository;
//
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    public List<Product> getAllProduct(){ return productRepository.findAll();
//    }
//
//    public void addProducts(Product product){
//        productRepository.save(product);
//    }
//
//    public void deleteProductById(long id){
//        productRepository.deleteById(id);
//    }
//
//    public Optional<Product> getProductById(long id){
//        return productRepository.findById(id);
//    }
//
////    public List<Product> getAllProductsByCategoryId(int id){
////        return productRepository.findAllByCategories_Id(id);
////    }
//
public List<Product> getAllProduct();
public void addProducts(Product product);

    public void deleteProductById(long id);

    public Optional<Product> getProductById(long id);
    public List<Product> findAllByCategoryId(int id);
    public List<Product> findByNameContaining(String keywords);


}
