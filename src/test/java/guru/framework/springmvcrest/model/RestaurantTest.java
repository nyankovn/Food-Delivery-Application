package guru.framework.springmvcrest.model;

import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.users.Profile;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    Restaurant restaurant = new Restaurant("Name1", "location", "+123456789", 10, 2, 20, 40);


    @Test
    void getName() {
        restaurant.setName("test");
    }

    @Test
    void getLocation() {
        restaurant.setLocation("test");
        Assert.assertSame(restaurant.getLocation(), "test");
    }

    @Test
    void getPhoneNumber() {
        restaurant.setPhoneNumber("test");
        Assert.assertSame(restaurant.getPhoneNumber(), "test");
    }

    @Test
    void getOpeningHour() {
        restaurant.setOpeningHour(9);
        Assert.assertSame(restaurant.getOpeningHour(), 9);
    }

    @Test
    void getClosingHour() {
        restaurant.setClosingHour(22);
        Assert.assertSame(restaurant.getClosingHour(), 22);
    }

    @Test
    void getMinMinsToPrepare() {
        restaurant.setMinMinsToPrepare(20);
        Assert.assertSame(restaurant.getMinMinsToPrepare(), 20);
    }

    @Test
    void getMaxMinsToPrepare() {
        restaurant.setMaxMinsToPrepare(40);
        Assert.assertSame(restaurant.getMaxMinsToPrepare(), 40);
    }

    @Test
    void getImg_dir() {
        restaurant.setImgDir("test");
        Assert.assertSame(restaurant.getImgDir(), "test");
    }

    List<Menu> menus = new ArrayList<>();
    List<Tag> tags = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    Profile profile = new Profile();

    @Test
    void getMenus() {
        restaurant.setMenus(menus);
        Assert.assertSame(restaurant.getMenus(), menus);

    }

    @Test
    void getTags() {
        restaurant.setTags(tags);
        Assert.assertSame(restaurant.getMenus(), menus);
    }

    @Test
    void getOrders() {
        restaurant.setOrders(orders);
        Assert.assertSame(restaurant.getOrders(), orders);
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
        restaurant.setImgDir("test");
        assertEquals("test", restaurant.getImgDir());
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


}