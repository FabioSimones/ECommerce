package dev.fabiosimones.ecommerce.repository;

import dev.fabiosimones.ecommerce.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
