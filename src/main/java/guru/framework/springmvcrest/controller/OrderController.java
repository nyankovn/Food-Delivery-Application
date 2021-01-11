package guru.framework.springmvcrest.controller;


import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.repository.OrderRepository;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(RestaurantController.BASE_URL)
public class OrderController {

    public static final String BASE_URL = "/admin_ui";

    private final OrderRepository orderRepository;
    private final ProfileRepository profileRepository;
    private final RestaurantRepository restaurantRepository;

    public OrderController(OrderRepository orderRepository, ProfileRepository profileRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.profileRepository = profileRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    private String orderWithId = "Order with id ";
    private String doesNotExist = " does not exists";

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));

        return ResponseEntity.ok(order);
    }

    public Profile getProfileById(@PathVariable Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));
    }

    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }


    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));

        order.setDateOrdered(orderDetails.getDateOrdered());
        order.setLocation(orderDetails.getLocation());

        Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));

        orderRepository.delete(order);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
