package com.nagarro.exitTestAssignment.model;
import lombok.Data;
import javax.persistence.*;
@Entity
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id")
    private  int id;
    @Column(name="categories_name")
    private String name;

}
