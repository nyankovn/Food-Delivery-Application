//package guru.framework.springmvcrest.model.menu;
//
//import guru.framework.springmvcrest.model.Order;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class ProductTest {
//
//    private Product product = new Product("name",12.25);
//
//    @Test
//    void constructorTest() {
//        Product test = new Product("name",12.25);
//        assertThat("name", is(test.getName()));
//        assertThat(12.25, is(test.getPrice()));
//    }
//
//
//
//    @Test
//    void getName() {
//        product.setName("test");
//        assertTrue(product.getName() == "test");
//    }
//
//    @Test
//    void getPrice() {
//        product.setPrice(2);
//        assertTrue(product.getPrice() == 2);
//    }
//
//
//
//    @Test
//    void getImg_dir() {
//        product.setImg_dir("test");
//        assertTrue(product.getImg_dir() == "test");
//    }
//
//    Menu menu=new Menu();
//    List<Order> orders=new ArrayList<>();
//
//    @Test
//    void getMenu() {
//        product.setMenu(menu);
//        assertTrue(product.getMenu() == menu);
//    }
//
//    @Test
//    void getOrders() {
//        product.setOrders(orders);
//        assertTrue(product.getOrders() == orders);
//    }
//
//
//    @Test
//    void setName() {
//        product.setName("test");
//
//        assertEquals("test", product.getName());
//    }
//
//    @Test
//    void setPrice() {
//        product.setPrice(5);
//
//        assertEquals(5, product.getPrice());
//    }
//
//
//    @Test
//    void setImg_dir() {
//        String imgDir="dir";
//        product.setImg_dir(imgDir);
//
//        assertEquals(imgDir, product.getImg_dir());
//    }
//
//    @Test
//    void setMenu() {
//        product.setMenu(menu);
//
//        assertEquals(menu, product.getMenu());
//    }
//
//    @Test
//    void setOrders() {
//        product.setOrders(orders);
//
//        assertEquals(orders, product.getOrders());
//    }
//}