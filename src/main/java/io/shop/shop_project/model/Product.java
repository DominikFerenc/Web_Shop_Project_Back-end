package io.shop.shop_project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //@NotNull(message = "Product name is required!")
    private String title;
    private Double price;
    private String description;
    private String picturelUrl;
}
