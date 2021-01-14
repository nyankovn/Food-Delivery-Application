package guru.framework.springmvcrest.model;

import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.users.Profile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order=new Order("location");

    @Test
    void getId() {
        order.setId(2);
        assertTrue(order.getId() == 2);
    }

    @Test
    void getLocation() {
        order.setLocation("test");
        assertEquals("test", order.getLocation());
    }

    List<Product>products=new ArrayList<>();
    Profile profile=new Profile();
    Restaurant restaurant=new Restaurant();

    @Test
    void getProducts() {
        order.setProducts(products);
        assertEquals(products, order.getProducts());
    }

    @Test
    void getProfile() {
        order.setProfile(profile);
        assertEquals(profile, order.getProfile());
    }

    @Test
    void getRestaurant() {
        order.setRestaurant(restaurant);
        assertEquals(restaurant, order.getRestaurant());
    }

    @Test
    void setId() {
        order.setId(2);
        assertEquals(2, order.getId());
    }

    @Test
    void setLocation() {
        order.setLocation("test");
        assertEquals("test", order.getLocation());
    }

    @Test
    void setProducts() {
        order.setProducts(products);
        assertEquals(products, order.getProducts());
    }

    @Test
    void setProfile() {
        order.setProfile(profile);
        assertEquals(profile, order.getProfile());
    }

    @Test
    void setRestaurant() {
        order.setRestaurant(restaurant);
        assertEquals(restaurant, order.getRestaurant());
    }
}