package io.shop.shop_project.controller.impl;

import io.shop.shop_project.controller.ProductController;
import io.shop.shop_project.model.Product;
import io.shop.shop_project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductRepository repository;


    @Override
    public ResponseEntity<Product> getProductByid(Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ResponseEntity<Product> saveProduct(Product toSave) {
        repository.save(toSave);
        URI location = URI.create(String.format("/%s", toSave.getId()));
        return ResponseEntity.created(location).build();
    }
}
