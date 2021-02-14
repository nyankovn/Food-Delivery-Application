package guru.framework.springmvcrest.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.framework.springmvcrest.controller.UserController;
import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.menu.TypeProduct;
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
class ProductServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ProductServiceImpl productService;

    List<Product> products;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        products = new ArrayList<>();

        Product drink=new Product("name1",2.00,150,"description1","img1", TypeProduct.drink);
        Product meal=new Product("name2",2.00,150,"description2","img2", TypeProduct.meal);

        products.add(drink);
        products.add(meal);
    }


    @Test
    void getAllProducts() {
    }

    @Test
    void getProductsById() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}