package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


//@Transactional
//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//
//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
//
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = User.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserRepository userRepository;

    @Test
    void testFindAll() {
        // given
        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");
        User user2 = new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98");
        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);

        when(userRepository.findAll()).thenReturn(users);

        // when
        List<User> result = userController.getAllUsers();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.get(0).getFirstName())
                .isEqualTo(user1.getFirstName());

        assertThat(result.get(1).getFirstName())
                .isEqualTo(user2.getFirstName());
    }

    @Test
    void testGetUserById() {

        when(userRepository.findById((long) 1)).thenReturn(java.util.Optional.of(new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98")));

        ResponseEntity<User> user = userController.getUserById((long) 1);

        assertEquals("Alex", user.getBody().getFirstName());
        assertEquals("Gussin", user.getBody().getLastName());
        assertEquals("+9638574142", user.getBody().getPhoneNumber());
        assertEquals("Kleine Berg 98", user.getBody().getAddress());
    }


    @Test
    void testAddUser() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("users/{id}")
                .buildAndExpand(user1.getId())
                .toUri();

        ResponseEntity<User> responseEntity = ResponseEntity.created(location).build();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }


    @Test
    void testUpdateUser() {
        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");
        userController.createUser(user1);

        User updated = new User("Lokesh", "Gupta", "+88888888", "Lombokpad 2a");

        ResponseEntity<User> responseEntity = userController.updateUser(user1.getId(), updated);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("users/1");
    }


    @Test
    void testDeleteUser() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");
        User user2 = new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98");
        List<User> users = new ArrayList<>();

        userController.createUser(user1);
        userController.createUser(user2);
        users.add(user1);
        users.add(user2);

        ResponseEntity<Map<String, Boolean>> responseEntity = userController.deleteUser(user1.getId());
        users.remove(user1);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity).isEqualTo(users);
        assertThat(responseEntity.getBody()).hasSize(1);
    }
}