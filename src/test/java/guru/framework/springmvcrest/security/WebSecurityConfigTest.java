package guru.framework.springmvcrest.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
class WebSecurityConfigTest {
//
    private WebSecurityConfig webSecurityConfig=new WebSecurityConfig();

    @Autowired
    private WebApplicationContext wac;

    public MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders
                .webAppContextSetup(this.wac)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .dispatchOptions(true);
        this.mockMvc = builder.build();
    }


//    @Test
//    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
////        mvc.perform(get("/admin_ui/authenticate/signin").contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk());
//
//        URI uri = UriComponentsBuilder.fromUriString("/admin_ui/authenticate/signin")
//                .build().encode().toUri();
//
//        mockMvc.perform(get(uri)).andExpect(status().isOk());
//
//    }

    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        mockMvc.perform(get("/admin_ui/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/admin_ui/users/13").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/admin_ui/restaurants").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/admin_ui/restaurants/top-rated").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/admin_ui/restaurants/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

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

    @Test
    public void testCors() throws Exception {
        this.mockMvc
                .perform(options("/test-cors")
                        .header("Access-Control-Request-Method", "GET")
                        .header("Origin", "http://www.someurl.com"));
    }


    @Test
    void passwordEncoder() {
        PasswordEncoder expected= NoOpPasswordEncoder.getInstance();
        PasswordEncoder result=webSecurityConfig.passwordEncoder();

        assertThat(expected).isEqualTo(result);

    }
}