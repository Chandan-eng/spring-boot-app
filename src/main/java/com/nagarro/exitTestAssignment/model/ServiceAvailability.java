package com.nagarro.exitTestAssignment.model;
import lombok.Data;
import javax.persistence.*;
@Entity
@Data
public class ServiceAvailability {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int pinCode;
private boolean availability;
//@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name="ProductCode",referencedColumnName="ProductCode")
//private Product product;
}
