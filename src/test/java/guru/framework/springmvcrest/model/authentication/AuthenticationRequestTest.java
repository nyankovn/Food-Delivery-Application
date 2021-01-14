package guru.framework.springmvcrest.model.authentication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationRequestTest {

    @Test
    void getUsername() {
        AuthenticationRequest request = new AuthenticationRequest("username", "password");
        request.setUsername("test");
        assertTrue(request.getUsername() == "test");
    }

    @Test
    void getPassword() {
        AuthenticationRequest request = new AuthenticationRequest("username", "password");
        request.setPassword("test");
        assertTrue(request.getPassword() == "test");
    }

    @Test
    void setUsername() {
        AuthenticationRequest request = new AuthenticationRequest("username", "password");
        request.setUsername("test");
        assertEquals("test", request.getUsername());
    }

    @Test
    void setPassword() {
        AuthenticationRequest request = new AuthenticationRequest("username", "password");
        request.setPassword("test");
        assertEquals("test", request.getPassword());
    }
}