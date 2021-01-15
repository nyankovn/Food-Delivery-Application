package guru.framework.springmvcrest.model.users;

import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    private User user = new User();
    private Profile profile = new Profile("email", "username", "password", user);

    @Test
    void getId() {
        profile.setId(2);
        assertTrue(profile.getId() == 2);
    }

    @Test
    void getEmail() {
        profile.setEmail("test");
        assertTrue(profile.getEmail() == "test");
    }

    @Test
    void getUsername() {
        profile.setUsername("test");
        assertTrue(profile.getUsername() == "test");
    }

    @Test
    void getPassword() {
        profile.setPassword("test");
        assertTrue(profile.getPassword() == "test");
    }

    @Test
    void isEnabled() {
        profile.setEnabled(true);
        assertTrue(profile.isEnabled() == true);
    }


    User newUser = new User();
    List<Restaurant> restaurants = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    List<Role> roles = new ArrayList<>();


    @Test
    void getProfileUser() {
        profile.setProfileUser(newUser);
        assertTrue(profile.getProfileUser() == newUser);
    }

    @Test
    void getRestaurants() {
        profile.setRestaurants(restaurants);
        assertTrue(profile.getRestaurants() == restaurants);
    }

    @Test
    void getOrders() {
        profile.setOrders(orders);
        assertTrue(profile.getOrders() == orders);
    }

    @Test
    void getRoles() {
        profile.setRoles(roles);
        assertTrue(profile.getRoles() == roles);
    }

    @Test
    void setId() {
        profile.setId(2);
        assertEquals(2, profile.getId());
    }

    @Test
    void setEmail() {
        profile.setEmail("test");
        assertEquals("test", profile.getEmail());
    }

    @Test
    void setUsername() {
        profile.setUsername("test");
        assertEquals("test", profile.getUsername());
    }

    @Test
    void setPassword() {
        profile.setPassword("test");
        assertEquals("test", profile.getPassword());
    }

    @Test
    void setEnabled() {
        profile.setEnabled(true);
        assertEquals(true, profile.isEnabled());
    }

    @Test
    void setProfileUser() {
        profile.setProfileUser(newUser);
        assertEquals(newUser, profile.getProfileUser());
    }

    @Test
    void setRestaurants() {
        profile.setRestaurants(restaurants);
        assertEquals(restaurants, profile.getRestaurants());

    }

    @Test
    void setOrders() {
        profile.setOrders(orders);
        assertEquals(orders, profile.getOrders());

    }

    @Test
    void setRoles() {
        profile.setRoles(roles);
        assertEquals(roles, profile.getRoles());
    }
}