package com.nagarro.exitTestAssignment.serviceImp;

import com.nagarro.exitTestAssignment.model.Product;
import com.nagarro.exitTestAssignment.repository.ProductRepository;
import com.nagarro.exitTestAssignment.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public  class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;


    // List<Product> products;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void addProducts(Product product) {

        productRepository.save(product);

    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllByCategoryId(int id) {
        return productRepository.findAllByCategoryId(id);
    }

    public List<Product> findByNameContaining(String keywords){
        return  productRepository.findByNameContaining(keywords);
    }

    //    public List<Product> getAllProductsByCategoryId(int id){
    //       return productRepository.findAllByCategories_Id(id);
    //   }
}

