package dev.fabiosimones.ecommerce.repository;

import dev.fabiosimones.ecommerce.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
