package guru.framework.springmvcrest.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.framework.springmvcrest.controller.MenuController;
import guru.framework.springmvcrest.controller.UserController;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"guru.framework.springmvcrest"})
@SpringBootTest
@AutoConfigureMockMvc
class MenuServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private MenuServiceImpl menuService;

    List<Menu> menus;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        menus = new ArrayList<>();

        List<Product>products1=new ArrayList<>();
        List<Product>products2=new ArrayList<>();

        Restaurant restaurant1=new Restaurant();
        Restaurant restaurant2=new Restaurant();

        Menu menu1 =new Menu("Title1",products1,restaurant1);
        Menu menu2 =new Menu("Title2",products2,restaurant2);

        menus.add(menu1);
        menus.add(menu2);
    }

    @Test
    void getAllMenus() {
    }

    @Test
    void getMenuById() {
    }

    @Test
    void getMenuByRestaurantId() {
    }

    @Test
    void createMenu() {
    }

    @Test
    void updateMenu() {
    }

    @Test
    void deleteMenu() {
    }
}