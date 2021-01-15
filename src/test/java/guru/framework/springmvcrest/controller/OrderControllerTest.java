package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class OrderControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderRepository orderRepository;

    @Test
    public void testGetAllOrders() {
        // given
        Order order1=new Order("location");
        Order order2=new Order("location2");

        List<Order> orders = new ArrayList<>();

        orders.add(order1);
        orders.add(order2);

        when(orderRepository.findAll()).thenReturn(orders);

        // when
        List<Order> result = orderController.getAllOrders();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.get(0).getLocation())
                .isEqualTo(order1.getLocation());

        assertThat(result.get(1).getLocation())
                .isEqualTo(order2.getLocation());
    }

    @Test
    void testGetOrderById() {

        when(orderRepository.findById((long) 1)).thenReturn(java.util.Optional.of(new Order("location")));

        ResponseEntity<Order> order = orderController.getOrderById((long) 1);

        assertEquals("location", order.getBody().getLocation());
    }

    @Test
    public void testAddOrder() {
        MockHttpServletRequest request = new MockHttpServletRequest();

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Order order1=new Order("location");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("orders/{id}")
                .buildAndExpand(order1.getId())
                .toUri();

        ResponseEntity<User> responseEntity = ResponseEntity.created(location).build();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}