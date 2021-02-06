package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.repository.OrderRepository;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final ProfileRepository profileRepository;
    private final RestaurantRepository restaurantRepository;

    private String orderWithId = "Order with id ";
    private String doesNotExist = " does not exists";


    public OrderServiceImpl(OrderRepository orderRepository, ProfileRepository profileRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.profileRepository = profileRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));

        return order;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));
        order.setLocation(orderDetails.getLocation());

        Order updatedOrder = orderRepository.save(order);
        return updatedOrder;
    }

    public Map<String, Boolean> deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));

        orderRepository.delete(order);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
