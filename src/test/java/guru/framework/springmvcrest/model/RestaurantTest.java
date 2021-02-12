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
        Assert.assertSame("test", restaurant.getName());

    }

    @Test
    void getLocation() {
        restaurant.setLocation("test");
        Assert.assertSame("test", restaurant.getLocation());
    }

    @Test
    void getPhoneNumber() {
        restaurant.setPhoneNumber("test");
        Assert.assertSame("test", restaurant.getPhoneNumber());
    }

    @Test
    void getOpeningHour() {
        restaurant.setOpeningHour(9);
        Assert.assertSame(9, restaurant.getOpeningHour());
    }

    @Test
    void getClosingHour() {
        restaurant.setClosingHour(22);
        Assert.assertSame(22, restaurant.getClosingHour());
    }

    @Test
    void getMinMinsToPrepare() {
        restaurant.setMinMinsToPrepare(20);
        Assert.assertSame(20, restaurant.getMinMinsToPrepare());
    }

    @Test
    void getMaxMinsToPrepare() {
        restaurant.setMaxMinsToPrepare(40);
        Assert.assertSame(40, restaurant.getMaxMinsToPrepare());
    }

    @Test
    void getImg_dir() {
        restaurant.setImgDir("test");
        Assert.assertSame("test", restaurant.getMaxMinsToPrepare());
    }

    List<Menu> menus = new ArrayList<>();
    List<Tag> tags = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    Profile profile = new Profile();

    @Test
    void getMenus() {
        restaurant.setMenus(menus);
        Assert.assertSame(menus, restaurant.getMenus());

    }

    @Test
    void getTags() {
        restaurant.setTags(tags);
        Assert.assertSame(menus, restaurant.getMenus());
    }

    @Test
    void getOrders() {
        restaurant.setOrders(orders);
        Assert.assertSame(orders, restaurant.getOrders());
    }

    @Test
    void getAverageRating() {
        restaurant.setMinMinsToPrepare(20);
        Assert.assertSame(20, restaurant.getMinMinsToPrepare());
    }

    @Test
    void getRating() {
        restaurant.setRatingTotal(5);
        Assert.assertSame(5, restaurant.getRating());
    }

    @Test
    void getProfile() {
        restaurant.setProfile(profile);
        Assert.assertSame(profile, restaurant.getProfile());
    }

    @Test
    void getRatingVotes() {
        restaurant.setRatingVotes();
        Assert.assertSame(1, restaurant.getRatingVotes());
    }


    @Test
    void setRatingVotes() {
        restaurant.setRatingVotes();
        assertEquals(restaurant.getRating(), 1);
    }

    @Test
    void setRatingTotal() {
        restaurant.setRatingTotal(5);
        assertEquals(restaurant.getRating(), 5);
    }

    @Test
    void setProfile() {
        restaurant.setProfile(profile);
        assertEquals(restaurant.getProfile(), profile);
    }

    @Test
    void setName() {
        restaurant.setName("test");
        assertEquals(restaurant.getName(), "test");
    }

    @Test
    void setLocation() {
        restaurant.setLocation("test");
        assertEquals(restaurant.getLocation(), "test");
    }

    @Test
    void setPhoneNumber() {
        restaurant.setPhoneNumber("test");
        assertEquals(restaurant.getPhoneNumber(), "test");
    }


    @Test
    void setOpeningHour() {
        restaurant.setOpeningHour(5);
        assertEquals(restaurant.getOpeningHour(), 5);
    }

    @Test
    void setClosingHour() {
        restaurant.setClosingHour(5);
        assertEquals(restaurant.getClosingHour(), 5);
    }

    @Test
    void setMinMinsToPrepare() {
        restaurant.setMaxMinsToPrepare(5);
        assertEquals(restaurant.getMaxMinsToPrepare(), 5);
    }

    @Test
    void setMaxMinsToPrepare() {
        restaurant.setMaxMinsToPrepare(5);
        assertEquals(restaurant.getMaxMinsToPrepare(), 5);
    }

    @Test
    void setImg_dir() {
        restaurant.setImgDir("test");
        assertEquals(restaurant.getImgDir(), "test");
    }

    @Test
    void setMenus() {
        restaurant.setMenus(menus);
        assertEquals(restaurant.getMenus(), menus);
    }

    @Test
    void setTags() {
        restaurant.setTags(tags);
        assertEquals(restaurant.getTags(), tags);
    }

    @Test
    void setOrders() {
        restaurant.setOrders(orders);
        assertEquals(restaurant.getOrders(), orders);
    }


}