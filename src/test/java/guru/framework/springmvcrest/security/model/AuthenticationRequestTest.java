package guru.framework.springmvcrest.security.model;

import org.junit.Assert;
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
        Assert.assertSame("test", request.getUsername());
    }

    @Test
    void getPassword() {
        request.setPassword("test");
        Assert.assertSame("test", request.getPassword());
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