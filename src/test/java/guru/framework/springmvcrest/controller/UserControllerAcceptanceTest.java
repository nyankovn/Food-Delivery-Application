package guru.framework.springmvcrest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerAcceptanceTest {

    @LocalServerPort
    int randomServerPort;

    private RestTemplate restTemplate;
    private String url;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
        url = "http://localhost:" + randomServerPort + "/admin_ui/";
    }

    @Test
    void shouldGetUsers() throws Exception {
        ResponseEntity responseEntity = restTemplate.getForEntity(url+"users", String.class);
        assertEquals(OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldGetUserId() throws Exception {

        ResponseEntity responseEntity = restTemplate.getForEntity(url+"user/1", String.class);
        assertEquals(OK, responseEntity.getStatusCode());
    }
}