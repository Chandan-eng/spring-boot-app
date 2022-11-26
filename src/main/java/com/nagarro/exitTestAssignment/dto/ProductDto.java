package com.nagarro.exitTestAssignment.dto;
import lombok.Data;
@Data
public class ProductDto {
    private Long id;
    private String name;
    private int categoryId;
    private double price;
    private double rating;
    private String description;
    private String imageName;
    private String brand;
}
