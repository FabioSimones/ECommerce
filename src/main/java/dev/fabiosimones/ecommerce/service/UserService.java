package dev.fabiosimones.ecommerce.service;

import dev.fabiosimones.ecommerce.controller.dto.CreateUserDTO;
import dev.fabiosimones.ecommerce.entities.BillingAddressEntity;
import dev.fabiosimones.ecommerce.entities.UserEntity;
import dev.fabiosimones.ecommerce.repository.BillingAddressRepository;
import dev.fabiosimones.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository,
                       BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDTO dto){

        var billingAddress = new BillingAddressEntity();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());

        var savedBillingAddress = billingAddressRepository.save(billingAddress);

        var user = new UserEntity();
        user.setFullName(dto.fullName());
        user.setBillingAddress(savedBillingAddress);

        return userRepository.save(user);
    }

    public Optional<UserEntity> findById(UUID userId) {
        return userRepository.findById(userId);
    }
}
