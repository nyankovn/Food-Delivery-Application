package guru.framework.springmvcrest.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.users.Profile;
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
class ProfileServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ProfileServiceImpl profileService;

    List<Profile> profiles;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        profiles = new ArrayList<>();

        User user1=new User();
        User user2=new User();

        Profile profile1=new Profile("email1","username1","password1",user1);
        Profile profile2=new Profile("email2","username2","password2",user2);

        profiles.add(profile1);
        profiles.add(profile2);
    }

    @Test
    void getAllProfiles() {
    }

    @Test
    void getAllProfilesByRole() {
    }

    @Test
    void createProfile() {
    }

    @Test
    void getProfileById() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void registerRestaurant() {
    }
}