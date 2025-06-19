package dev.fabiosimones.ecommerce.controller.dto;

import dev.fabiosimones.ecommerce.entities.OrderEntity;
import dev.fabiosimones.ecommerce.entities.OrderItemEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponseDTO(Long orderId, BigDecimal total, 
                               LocalDateTime orderDate, 
                               UUID userId, 
                               List<OrderItemResponseDTO> items) {

    public static OrderResponseDTO fromEntity(OrderEntity entity){
        return new OrderResponseDTO(
                entity.getOrderId(),
                entity.getTotal(),
                entity.getOrderDate(),
                entity.getUser().getUserId(),
                getItems(entity.getItems())
        );
    }

    private static List<OrderItemResponseDTO> getItems(List<OrderItemEntity> items) {
        return items.stream().map(OrderItemResponseDTO::fromEntity).toList();
    }
}
