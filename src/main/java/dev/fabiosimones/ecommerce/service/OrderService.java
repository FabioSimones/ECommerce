package dev.fabiosimones.ecommerce.service;

import dev.fabiosimones.ecommerce.controller.dto.CreateOrderDTO;
import dev.fabiosimones.ecommerce.controller.dto.OrderItemDTO;
import dev.fabiosimones.ecommerce.entities.*;
import dev.fabiosimones.ecommerce.exception.CreateOrderException;
import dev.fabiosimones.ecommerce.repository.OrderItemRepository;
import dev.fabiosimones.ecommerce.repository.OrderRepository;
import dev.fabiosimones.ecommerce.repository.ProductRepository;
import dev.fabiosimones.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderEntity createOrder(CreateOrderDTO dto){

        var order = new OrderEntity();

        //Validate User
        var user = validateUser(dto);

        //Validate OrderItems
        var orderItems = validateOrderItems(order, dto);

        //Calculate OrderTotal
        var total = calculateOrderTotal(orderItems);

        //Map to entity
        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        order.setItems(orderItems);
        order.setTotal(total);

        //Repository save
        return orderRepository.save(order);
    }

    private BigDecimal calculateOrderTotal(List<OrderItemEntity> orderItems) {
        return orderItems.stream()
                .map(i -> i.getSalePrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private List<OrderItemEntity> validateOrderItems(OrderEntity order, CreateOrderDTO dto) {
        if(dto.items().isEmpty()){
            throw new CreateOrderException("Order items is empty.");
        }
        return dto.items().stream().map(orderItemDTO -> getOrderItem(order, orderItemDTO)).toList();
    }

    private OrderItemEntity getOrderItem(OrderEntity order,OrderItemDTO orderItemDTO) {
        var orderItemEntity = new OrderItemEntity();
        var id = new OrderItemId();
        var product = getProduct(orderItemDTO.productId());

        id.setOrder(order);
        id.setProduct(product);

        orderItemEntity.setId(id);
        orderItemEntity.setQuantity(orderItemDTO.quantity());
        orderItemEntity.setSalePrice(product.getPrice());

        return orderItemEntity;
    }

    private ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new CreateOrderException("Product not found."));
    }

    private UserEntity validateUser(CreateOrderDTO dto){
        return userRepository.findById(dto.userId()).orElseThrow(() -> new CreateOrderException("User not found."));
    }
}
