package guru.framework.springmvcrest.model.authentication;

import guru.framework.springmvcrest.model.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationRequestTest {

    private AuthenticationRequest request = new AuthenticationRequest("username", "password");

    @Test
    void constructorTest() {
        AuthenticationRequest authenticationRequest=new AuthenticationRequest();
        authenticationRequest.setPassword("test");
        assertEquals("test", authenticationRequest.getPassword());
    }


    @Test
    void getUsername() {
        request.setUsername("test");
        assertTrue(request.getUsername() == "test");
    }

    @Test
    void getPassword() {
        request.setPassword("test");
        assertTrue(request.getPassword() == "test");
    }

    @Test
    void setUsername() {
        request.setUsername("test");
        assertEquals("test", request.getUsername());
    }

    @Test
    void setPassword() {
        request.setPassword("test");
        assertEquals("test", request.getPassword());
    }
}