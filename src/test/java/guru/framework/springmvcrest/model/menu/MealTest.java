package guru.framework.springmvcrest.model.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    private Meal meal = new Meal("name",12,12,"description");

    @Test
    void getDescription() {
        meal.setDescription("test");
        assertTrue(meal.getDescription() == "test");
    }

    @Test
    void setDescription() {
        meal.setDescription("test");
        assertEquals("test", meal.getDescription());
    }
}