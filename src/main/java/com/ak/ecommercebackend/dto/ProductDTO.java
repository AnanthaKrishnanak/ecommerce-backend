package com.ak.ecommercebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int productId;
    private String productName;
    private String productImageUrl;
    private double productPrice;
    private int productStock;
    private String productDescription;
    private Boolean inStock;
    private Date createdAt;
    private String brand;
    private int rating;
    private int reviewCount;
    private Long categoryId;
}
