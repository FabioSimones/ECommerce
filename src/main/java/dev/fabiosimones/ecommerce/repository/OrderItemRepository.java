package dev.fabiosimones.ecommerce.repository;

import dev.fabiosimones.ecommerce.entities.OrderItemEntity;
import dev.fabiosimones.ecommerce.entities.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemId> {
}
