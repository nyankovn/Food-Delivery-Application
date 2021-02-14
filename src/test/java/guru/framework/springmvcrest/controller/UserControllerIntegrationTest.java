package guru.framework.springmvcrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"guru.framework.springmvcrest"})
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private UserController userController;

    List<User> users;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        users = new ArrayList<>();
        User user1 = new User("Lokesh", "Gupta", "+5265454", "Lombokpad 2a");
        User user2 = new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }

    @Test
    void shouldGetUserById() throws Exception {
        User user = new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98");
        when(userController.getUserById((long) 1)).thenReturn(ResponseEntity.ok(user));
        mockMvc.perform(get("/admin_ui/users/" + user.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetUsers() throws Exception {
        User user = new User("Alex", "Gussin", "+9638574142", "Kleine Berg 98");
        when(userController.getUserById((long) 1)).thenReturn(ResponseEntity.ok(user));
        mockMvc.perform(get("/admin_ui/users/" + user.getId()))
                .andExpect(status().isOk());
    }

//    @Test
//    void testAddUser() throws Exception {
//        User newUser = new User();
//
//        newUser.setAddress("address");
//
//        Mockito.doNothing().when(userController).createUser(isA(User.class));
//        users.add(newUser);
//
//        String json = objectMapper.writeValueAsString(newUser);
//
//        RequestBuilder builder = MockMvcRequestBuilders.post("/admin_ui/users/").contentType(MediaType.APPLICATION_JSON).content(json);
//
//        MvcResult result = mockMvc.perform(builder).andReturn();
//        String content = result.getResponse().getContentAsString();
//
//
//        Assert.assertEquals(json, content);
//
//
//
//        Mockito.when(userController.createUser(Mockito.any(User.class))).thenReturn(ResponseEntity.ok(newUser));
//        users.add(newUser);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
//                "/api/hobbybook/users/update/0").accept(MediaType.APPLICATION_JSON).content(exampleAccountJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//
//        MvcResult result = mockmvc.perform(requestBuilder).andReturn();
//        String content = result.getResponse().getContentAsString();
//
//        String expected = objectMapper.writeValueAsString(a1);
//
//        Assert.assertEquals(expected, content);
//    }
}