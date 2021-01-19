package guru.framework.springmvcrest.model;

import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.users.Profile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    Restaurant restaurant = new Restaurant("Name1", "location", "+123456789", 0, 0, 10, 2, 20, 40);


    @Test
    void getName() {
        restaurant.setName("test");
        assertTrue(restaurant.getName() == "test");
    }

    @Test
    void getLocation() {
        restaurant.setLocation("test");
        assertTrue(restaurant.getLocation() == "test");
    }

    @Test
    void getPhoneNumber() {
        restaurant.setPhoneNumber("test");
        assertTrue(restaurant.getPhoneNumber() == "test");
    }

    @Test
    void getRating() {
        restaurant.setRating(5);
        assertTrue(restaurant.getRating() == 5);
    }

    @Test
    void getRatingVotes() {
        restaurant.setRatingVotes(5);
        assertTrue(restaurant.getRatingVotes() == 5);
    }

    @Test
    void getOpeningHour() {
        restaurant.setOpeningHour(9);
        assertTrue(restaurant.getOpeningHour() == 9);
    }

    @Test
    void getClosingHour() {
        restaurant.setClosingHour(22);
        assertTrue(restaurant.getClosingHour() == 22);
    }

    @Test
    void getMinMinsToPrepare() {
        restaurant.setMinMinsToPrepare(20);
        assertTrue(restaurant.getMinMinsToPrepare() == 20);
    }

    @Test
    void getMaxMinsToPrepare() {
        restaurant.setMaxMinsToPrepare(40);
        assertTrue(restaurant.getMaxMinsToPrepare() == 40);
    }

    @Test
    void getImg_dir() {
        restaurant.setImg_dir("test");
        assertTrue(restaurant.getImg_dir() == "test");
    }

    List<Menu>menus=new ArrayList<>();
    List<Tag>tags=new ArrayList<>();
    List<Order>orders=new ArrayList<>();
    Profile profile=new Profile();
    @Test
    void getMenus() {
        restaurant.setMenus(menus);
        assertTrue(restaurant.getMenus() == menus);
    }

    @Test
    void getTags() {
        restaurant.setTags(tags);
        assertTrue(restaurant.getTags() == tags);
    }

    @Test
    void getOrders() {
        restaurant.setOrders(orders);
        assertTrue(restaurant.getOrders() == orders);
    }

    @Test
    void getProfile() {
        restaurant.setProfile(profile);
        assertTrue(restaurant.getProfile() == profile);
    }



    @Test
    void setName() {
        restaurant.setName("test");
        assertEquals("test", restaurant.getName());
    }

    @Test
    void setLocation() {
        restaurant.setLocation("test");
        assertEquals("test", restaurant.getLocation());
    }

    @Test
    void setPhoneNumber() {
        restaurant.setPhoneNumber("test");
        assertEquals("test", restaurant.getPhoneNumber());
    }

    @Test
    void setRating() {
        restaurant.setRating(5);
        assertEquals(5, restaurant.getRating());
    }

    @Test
    void setRatingVotes() {
        restaurant.setRatingVotes(5);
        assertEquals(5, restaurant.getRatingVotes());
    }

    @Test
    void setOpeningHour() {
        restaurant.setOpeningHour(5);
        assertEquals(5, restaurant.getOpeningHour());
    }

    @Test
    void setClosingHour() {
        restaurant.setClosingHour(5);
        assertEquals(5, restaurant.getClosingHour());
    }

    @Test
    void setMinMinsToPrepare() {
        restaurant.setMaxMinsToPrepare(5);
        assertEquals(5, restaurant.getMaxMinsToPrepare());
    }

    @Test
    void setMaxMinsToPrepare() {
        restaurant.setMaxMinsToPrepare(5);
        assertEquals(5, restaurant.getMaxMinsToPrepare());
    }

    @Test
    void setImg_dir() {
        restaurant.setImg_dir("test");
        assertEquals("test", restaurant.getImg_dir());
    }

    @Test
    void setMenus() {
        restaurant.setMenus(menus);
        assertEquals(menus, restaurant.getMenus());
    }

    @Test
    void setTags() {
        restaurant.setTags(tags);
        assertEquals(tags, restaurant.getTags());
    }

    @Test
    void setOrders() {
        restaurant.setOrders(orders);
        assertEquals(orders, restaurant.getOrders());
    }

    @Test
    void setProfile() {
        restaurant.setProfile(profile);
        assertEquals(profile, restaurant.getProfile());
    }
}