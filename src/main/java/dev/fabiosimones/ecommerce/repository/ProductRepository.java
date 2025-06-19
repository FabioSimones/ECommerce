package dev.fabiosimones.ecommerce.repository;

import dev.fabiosimones.ecommerce.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
