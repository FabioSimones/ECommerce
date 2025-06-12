package dev.fabiosimones.ecommerce.repository;

import dev.fabiosimones.ecommerce.entities.BillingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, Long> {
}
