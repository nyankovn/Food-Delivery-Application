package guru.framework.springmvcrest.service.serviceImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"guru.framework.springmvcrest"})
@SpringBootTest
@AutoConfigureMockMvc
class AuthenticateServiceImplTest {



    @Test
    void createAuthenticationToken() {
    }

    @Test
    void signupCustomer() {
    }
}