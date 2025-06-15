package dev.fabiosimones.ecommerce.controller;

import dev.fabiosimones.ecommerce.controller.dto.CreateUserDTO;
import dev.fabiosimones.ecommerce.entities.UserEntity;
import dev.fabiosimones.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO dto){
        var user = userService.createUser(dto);

        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> findById(@PathVariable("userId")UUID userId){
        var user = userService.findById(userId);
        return user.isPresent() ?
                ResponseEntity.ok(user.get()) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserEntity> deleteById(@PathVariable("userId")UUID userId){
        var deleted = userService.deleteById(userId);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
