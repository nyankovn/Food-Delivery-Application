package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;

    private String orderWithId = "Order with id ";
    private String doesNotExist = " does not exists";


    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(orderWithId + id + doesNotExist));
        order.setLocation(orderDetails.getLocation());

        return orderRepository.save(order);
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
