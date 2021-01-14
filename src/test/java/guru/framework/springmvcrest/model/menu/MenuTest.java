package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private List<Product> products=new ArrayList<>();
    private Restaurant restaurant=new Restaurant();
    private Menu menu = new Menu("title",products,restaurant);


    @Test
    void getId() {
        menu.setId(3);
        assertTrue(menu.getId() == 3);
    }

    @Test
    void setId() {
        menu.setId(2);
        assertEquals(2, menu.getId());
    }

    @Test
    void getTitle() {
        menu.setTitle("test");
        assertTrue(menu.getTitle() == "test");
    }

    @Test
    void setTitle() {
        menu.setTitle("test");
        assertEquals("test", menu.getTitle());
    }

    List<Product> newProducts=new ArrayList<>();
    Restaurant newRestaurant=new Restaurant();

    @Test
    void getProducts() {
        menu.setProducts(newProducts);
        assertTrue(menu.getProducts() == newProducts);
    }

    @Test
    void setProducts() {
        menu.setProducts(newProducts);
        assertEquals(newProducts, menu.getProducts());
    }

    @Test
    void getRestaurant() {
        menu.setRestaurant(newRestaurant);
        assertTrue(menu.getRestaurant() == newRestaurant);
    }

    @Test
    void setRestaurant() {
        menu.setRestaurant(newRestaurant);
        assertEquals(newRestaurant, menu.getRestaurant());
    }
}