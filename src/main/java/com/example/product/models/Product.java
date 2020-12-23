package com.example.product.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Product {
    @Id @Getter @Setter private String id;
    @Getter @Setter private String image;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private Double price;
    @Getter @Setter private Timestamp createdDate;
}
