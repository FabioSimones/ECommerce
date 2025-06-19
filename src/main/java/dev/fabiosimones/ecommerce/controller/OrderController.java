package dev.fabiosimones.ecommerce.controller;

import dev.fabiosimones.ecommerce.controller.dto.*;
import dev.fabiosimones.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDTO dto){
        var order = orderService.createOrder(dto);

        return ResponseEntity.created(URI.create("/orders/" + order.getOrderId())).build();
    }

    @GetMapping
    public ResponseEntity<ApiResponse<OrderSummaryDTO>> listOrders(@RequestParam(name = "page", defaultValue = "0")Integer page,
                                                                   @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize){
        var response = orderService.findAll(page, pageSize);

        return ResponseEntity.ok(new ApiResponse<>(
                response.getContent(),
                new PaginationResponseDTO(response.getNumber(), response.getSize(),
                        response.getTotalElements(), response.getTotalPages())
        ));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> findById(@PathVariable("orderId")Long orderId){
        var order = orderService.findById(orderId);

        return order.isPresent() ?
                ResponseEntity.ok(OrderResponseDTO.fromEntity(order.get())) :
                ResponseEntity.notFound().build();
    }
}
