package dev.fabiosimones.ecommerce.controller.dto;

import dev.fabiosimones.ecommerce.entities.OrderItemEntity;

import java.math.BigDecimal;

public record OrderItemResponseDTO(BigDecimal salePrice,
                                   Integer quantity,
                                   ProductResponseDTO product) {
    public static OrderItemResponseDTO fromEntity(OrderItemEntity entity) {
        return new OrderItemResponseDTO(
                entity.getSalePrice(),
                entity.getQuantity(),
                ProductResponseDTO.fromEntity(entity.getId().getProduct())
        );
    }
}
