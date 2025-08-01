package com.ak.ecommercebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private int productId;
    private String productName;
    private String productImageUrl;
    private double productPrice;
    private int productStock;
    private String productDescription;
    private String productCategory;
    private Boolean inStock;
    private Date createdAt;
    private String brand;
    private int rating;
    private int reviewCount;
}
