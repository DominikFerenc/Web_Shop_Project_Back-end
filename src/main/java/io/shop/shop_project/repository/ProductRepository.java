package io.shop.shop_project.repository;

import io.shop.shop_project.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Page<Product> findAll(Pageable page);

    Optional<Product> findById(Long id);

    Product save(Product entity);
}
