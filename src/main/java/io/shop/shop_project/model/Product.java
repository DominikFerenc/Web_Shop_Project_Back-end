package io.shop.shop_project.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotNull(message = "Product name is required!")
    private String title;
    private Double price;
    private String description;
    private String picturelUrl;

    public Product(Long id, String title, Double price, String description, String picturelUrl) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.picturelUrl = picturelUrl;
    }


}
