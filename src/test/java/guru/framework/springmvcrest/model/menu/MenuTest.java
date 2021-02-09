package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Restaurant;
import org.junit.Assert;
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
        Assert.assertSame(3, menu.getId());
    }

    @Test
    void setId() {
        menu.setId(2);
        assertEquals(2, menu.getId());
    }

    @Test
    void getTitle() {
        menu.setTitle("test");
        Assert.assertSame("test", menu.getTitle());
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
        Assert.assertSame(newProducts, menu.getProducts());
    }

    @Test
    void setProducts() {
        menu.setProducts(newProducts);
        assertEquals(newProducts, menu.getProducts());
    }

    @Test
    void getRestaurant() {
        menu.setRestaurant(newRestaurant);
        Assert.assertSame(newRestaurant, menu.getRestaurant());
    }

    @Test
    void setRestaurant() {
        menu.setRestaurant(newRestaurant);
        assertEquals(newRestaurant, menu.getRestaurant());
    }
}