package io.shop.shop_project.controller;

import io.shop.shop_project.model.Product;
import io.shop.shop_project.repository.ProductRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
public interface ProductController {



    @ApiOperation(value = "Getting prducts from db")
    @GetMapping(value = "{id}")
    ResponseEntity<Product> getProductByid(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts();

    @PostMapping
    ResponseEntity<Product> saveProduct(@RequestBody Product toSave);


}
