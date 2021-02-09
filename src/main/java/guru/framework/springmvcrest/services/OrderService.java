package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order createOrder(Order order);

    Order updateOrder(Long id, Order orderDetails);

    Map<String, Boolean> deleteOrder(Long id);
}
