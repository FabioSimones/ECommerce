package dev.fabiosimones.ecommerce.controller.dto;

import dev.fabiosimones.ecommerce.entities.ProductEntity;
import dev.fabiosimones.ecommerce.entities.TagEntity;

import java.util.List;

public record ProductResponseDTO(Long productId,
                                 String productName,
                                 List<TagResponseDTO> tag) {
    public static ProductResponseDTO fromEntity(ProductEntity product) {
        return new ProductResponseDTO(
                product.getProductId(),
                product.getProductName(),
                getTags(product.getTags())
        );
    }

    private static List<TagResponseDTO> getTags(List<TagEntity> tags) {
        return tags.stream().map(TagResponseDTO::fromEntity).toList();
    }
}
