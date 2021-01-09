package guru.framework.springmvcrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.framework.springmvcrest.model.users.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc()
@AutoConfigureTestDatabase
class UserControllerTest {

    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mvc;

    @InjectMocks
    private UserController userController;

    List<User> users;

    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setMockMvc() {
//        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();

        users = new ArrayList<>();

        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");
        User user2 = new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98");

        users.add(user1);
        users.add(user2);
    }

    @Test
    void testFindAll() throws Exception{

        Mockito.when(userController.getAllUsers()).thenReturn(users);

        RequestBuilder builder = MockMvcRequestBuilders.get("/admin_ui/users");

        MvcResult mvcResult = mvc.perform(builder).andReturn();

        String content=mvcResult.getResponse().getContentAsString();
        String expected=objectMapper.writeValueAsString(users);

        Assert.assertEquals(content,expected);
    }

//    @Test
//    void testGetUserById() {
//
//        when(userRepository.findById((long) 1)).thenReturn(java.util.Optional.of(new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98")));
//
//        ResponseEntity<User> user = userController.getUserById((long) 1);
//
//        assertEquals("Alex", user.getBody().getFirstName());
//        assertEquals("Gussin", user.getBody().getLastName());
//        assertEquals("+9638574142", user.getBody().getPhoneNumber());
//        assertEquals("Kleine Berg 98", user.getBody().getAddress());
//    }
//
//
//    @Test
//    void testAddUser() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("users/{id}")
//                .buildAndExpand(user1.getId())
//                .toUri();
//
//        ResponseEntity<User> responseEntity = ResponseEntity.created(location).build();
//
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//    }
//
//
//    @Test
//    void testUpdateUser() {
//        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");
//        userController.createUser(user1);
//
//        User updated = new User("Lokesh", "Gupta", "+88888888", "Lombokpad 2a");
//
//        ResponseEntity<User> responseEntity = userController.updateUser(user1.getId(), updated);
//
//        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
//        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("users/1");
//    }
//
//
//    @Test
//    void testDeleteUser() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");
//        User user2 = new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98");
//        List<User> users = new ArrayList<>();
//
//        userController.createUser(user1);
//        userController.createUser(user2);
//        users.add(user1);
//        users.add(user2);
//
//        ResponseEntity<Map<String, Boolean>> responseEntity = userController.deleteUser(user1.getId());
//        users.remove(user1);
//
//        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
//        assertThat(responseEntity).isEqualTo(users);
//        assertThat(responseEntity.getBody()).hasSize(1);
//    }


}