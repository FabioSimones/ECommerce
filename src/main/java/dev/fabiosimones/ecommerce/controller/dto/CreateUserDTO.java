package dev.fabiosimones.ecommerce.controller.dto;

public record CreateUserDTO(String fullName,
                            String address,
                            String number,
                            String complement) {
}
