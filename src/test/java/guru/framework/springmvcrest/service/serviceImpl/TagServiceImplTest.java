package guru.framework.springmvcrest.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.framework.springmvcrest.controller.UserController;
import guru.framework.springmvcrest.model.Tag;
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
class TagServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private TagServiceImpl tagService;

    List<Tag> tags;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        tags = new ArrayList<>();

        Tag tag1 = new Tag("name1");
        Tag tag2 = new Tag("name2");

        tags.add(tag1);
        tags.add(tag2);
    }

    @Test
    void getAllTags() {
    }

    @Test
    void getTagById() {
    }

    @Test
    void createTag() {
    }

    @Test
    void updateTag() {
    }

    @Test
    void deleteTag() {
    }
}