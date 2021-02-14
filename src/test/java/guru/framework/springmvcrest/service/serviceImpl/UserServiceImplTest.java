package guru.framework.springmvcrest.service.serviceImpl;

import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"guru.framework.springmvcrest"})
@SpringBootTest
@AutoConfigureMockMvc
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    @Test
    void getAllUsers() {
    }

    @Test
    void getUserById() throws Exception {

    }

    @Test
    void createUser() {
        User user = new User();
        user.setFirstName("Alex");
        user.setLastName("Gussin");
        user.setPhoneNumber("+9638574142");
        user.setAddress("Kleine Berg 98");

        when(userRepository.save(new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98"))).thenReturn(new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98"));

        User created = userService.createUser(user);

        assertSame(created.getFirstName(), user.getFirstName());
        assertSame(user.getFirstName(),userService.createUser(user));

    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}