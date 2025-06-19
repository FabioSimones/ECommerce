package dev.fabiosimones.ecommerce.controller.dto;

public record PaginationResponseDTO(Integer pagem, Integer pageSize, Long totalElements, Integer totalPages) {
}
