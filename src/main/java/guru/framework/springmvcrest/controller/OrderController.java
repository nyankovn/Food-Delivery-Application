package guru.framework.springmvcrest.controller;


import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.repository.OrderRepository;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.services.OrderService;
import guru.framework.springmvcrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return new ResponseEntity<>(orderService.updateOrder(id, orderDetails), HttpStatus.OK);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    }
}
