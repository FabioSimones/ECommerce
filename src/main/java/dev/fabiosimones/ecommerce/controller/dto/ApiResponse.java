package dev.fabiosimones.ecommerce.controller.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data, PaginationResponseDTO pagination) {
}
