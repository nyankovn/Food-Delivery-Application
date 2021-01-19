package guru.framework.springmvcrest.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TagTest {

    private Tag tag=new Tag();


    @Test
    void getName() {
        tag.setName("test");
        assertEquals("test", tag.getName());
    }

    @Test
    void setName() {
        tag.setName("test");
        assertEquals("test", tag.getName());
    }

    List<Restaurant> restaurants=new ArrayList<>();

    @Test
    void getRestaurants() {
        tag.setRestaurants(restaurants);
        assertTrue(tag.getRestaurants() == restaurants);
    }

    @Test
    void setRestaurants() {
        tag.setRestaurants(restaurants);
        assertEquals(restaurants, tag.getRestaurants());
    }


}