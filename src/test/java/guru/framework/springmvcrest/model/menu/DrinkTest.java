package guru.framework.springmvcrest.model.menu;

import guru.framework.springmvcrest.model.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    private Drink drink = new Drink("name",12,12,1);

    @Test
    void constructorTest() {
        Drink drink=new Drink();
        drink.setName("test");
        assertEquals("test", drink.getName());
    }

    @Test
    void secondConstructorTest() {
        assertEquals("name", drink.getName());
        assertEquals(12, drink.getPrice());
        assertEquals(12, drink.getAmount());
        assertEquals(1, drink.getId());
    }
}