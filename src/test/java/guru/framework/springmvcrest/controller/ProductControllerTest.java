package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.menu.Product;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.ProductRepository;
import guru.framework.springmvcrest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ProductControllerTest {
    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;

    @Test
    public void testFindAll() {
        // given
        Product product1=new Product("name",12.25,1);
        Product product2=new Product("name2",2.75,1);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        when(productRepository.findAll()).thenReturn(products);

        // when
        List<Product> result = productController.getAllProducts();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.get(0).getName())
                .isEqualTo(product1.getName());

        assertThat(result.get(1).getName())
                .isEqualTo(product2.getName());
    }
}