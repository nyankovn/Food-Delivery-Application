package guru.framework.springmvcrest.security;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebSecurityConfig.class)
@WebAppConfiguration
//@WebIntegrationTest

class WebSecurityConfigTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;



    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
//        mvc.perform(get("/admin_ui/authenticate/signin").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());

        URI uri = UriComponentsBuilder.fromUriString("/admin_ui/authenticate/signin")
                .build().encode().toUri();

        mvc.perform(get(uri)).andExpect(status().isOk());

    }




//    @Test
//    void corsFilter() {
//    }
//
//    @Test
//    void corsConfigurer() {
//    }
//
//    @Test
//    void corsConfigurationSource() {
//    }
//
//    @Test
//    void passwordEncoder() {
//    }
}