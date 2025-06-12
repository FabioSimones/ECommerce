package dev.fabiosimones.ecommerce.repository;

import dev.fabiosimones.ecommerce.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity,UUID> {
}
