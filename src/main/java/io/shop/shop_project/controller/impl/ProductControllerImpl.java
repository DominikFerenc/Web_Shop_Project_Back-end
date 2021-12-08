package io.shop.shop_project.controller.impl;

import io.shop.shop_project.controller.ProductController;
import io.shop.shop_project.model.Product;
import io.shop.shop_project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductRepository repository;
    private final Logger logger = LoggerFactory.getLogger(ProductControllerImpl.class);

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
        logger.info("All products read.");
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ResponseEntity<Product> saveProduct(Product toSave) {
        logger.info("A new product has been added.");
        repository.save(toSave);
        URI location = URI.create(String.format("/%s", toSave.getId()));
        return ResponseEntity.created(location).build();
    }
}
