package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.authentication.AuthenticationResponse;
import guru.framework.springmvcrest.model.users.Role;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product = new Product("name",12.25, 12.25);

    @Test
    void getId() {
        product.setId(2);
        assertTrue(product.getId() == 2);
    }

    @Test
    void getName() {
        product.setName("test");
        assertTrue(product.getName() == "test");
    }

    @Test
    void getPrice() {
        product.setPrice(2);
        assertTrue(product.getPrice() == 2);
    }

    @Test
    void getAmount() {
        product.setAmount(2);
        assertTrue(product.getAmount() == 2);
    }

    @Test
    void getImg_dir() {
        product.setImg_dir("test");
        assertTrue(product.getImg_dir() == "test");
    }

    Menu menu=new Menu();
    List<Order> orders=new ArrayList<>();

    @Test
    void getMenu() {
        product.setMenu(menu);
        assertTrue(product.getMenu() == menu);
    }

    @Test
    void getOrders() {
        product.setOrders(orders);
        assertTrue(product.getOrders() == orders);
    }

    @Test
    void setId() {
        product.setId(2);

        assertEquals(2, product.getId());
    }

    @Test
    void setName() {
        product.setName("test");

        assertEquals("test", product.getName());
    }

    @Test
    void setPrice() {
        product.setPrice(5);

        assertEquals(5, product.getPrice());
    }

    @Test
    void setAmount() {
        product.setAmount(5);

        assertEquals(5, product.getAmount());
    }

    @Test
    void setImg_dir() {
        String imgDir="dir";
        product.setImg_dir(imgDir);

        assertEquals(imgDir, product.getImg_dir());
    }

    @Test
    void setMenu() {
        product.setMenu(menu);

        assertEquals(menu, product.getMenu());
    }

    @Test
    void setOrders() {
        product.setOrders(orders);

        assertEquals(orders, product.getOrders());
    }
}