package com.nagarro.exitTestAssignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

@JsonIgnoreProperties({"category"})
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Categories category;
    private double price;
    private double rating;
    private String description;
    private String imageName;
    private String brand;
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="availability",referencedColumnName="availability")
//    private ServiceAvailability availability;

}
