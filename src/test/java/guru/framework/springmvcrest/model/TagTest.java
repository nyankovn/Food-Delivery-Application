package guru.framework.springmvcrest.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TagTest {

    private Tag tag=new Tag();

    @Test
    void getId() {
        tag.setId(2);
        assertTrue(tag.getId() == 2);
    }

    @Test
    void setId() {
        tag.setId(2);
        assertEquals(2, tag.getId());
    }

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