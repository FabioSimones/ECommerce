package dev.fabiosimones.ecommerce.controller.dto;

import dev.fabiosimones.ecommerce.entities.TagEntity;

import java.util.List;

public record TagResponseDTO(Long tagId,
                             String name) {
    public static TagResponseDTO fromEntity(TagEntity entity) {
        return new TagResponseDTO(
                entity.getTagId(),
                entity.getName()
        );
    }
}
