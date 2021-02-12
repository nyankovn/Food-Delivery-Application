package guru.framework.springmvcrest.model.users;

import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.Restaurant;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    private User user = new User();
    private Profile profile = new Profile("email", "username", "password", user);


    @Test
    void getEmail() {
        profile.setEmail("test");
        Assert.assertSame("test",profile.getEmail() );
    }

    @Test
    void getUsername() {
        profile.setUsername("test");
        Assert.assertSame("test",profile.getUsername() );
    }

    @Test
    void getPassword() {
        profile.setPassword("test");
        Assert.assertSame("test",profile.getPassword() );
    }

    @Test
    void isEnabled() {
        profile.setEnabled(true);
        Assert.assertSame(true,profile.isEnabled() );
    }


    User newUser = new User();
    List<Restaurant> restaurants = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    List<Role> roles = new ArrayList<>();


    @Test
    void getProfileUser() {
        profile.setProfileUser(newUser);
        Assert.assertSame(newUser,profile.getProfileUser() );
    }

    @Test
    void getRestaurants() {
        profile.setRestaurants(restaurants);
        Assert.assertSame(restaurants,profile.getRestaurants() );
    }

    @Test
    void getOrders() {
        profile.setOrders(orders);
        Assert.assertSame(orders,profile.getOrders() );
    }

    @Test
    void getRoles() {
        profile.setRoles(roles);
        Assert.assertSame(roles,profile.getRoles() );
    }

    @Test
    void setId() {
        profile.setId(1);
        assertEquals(1, profile.getId());
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