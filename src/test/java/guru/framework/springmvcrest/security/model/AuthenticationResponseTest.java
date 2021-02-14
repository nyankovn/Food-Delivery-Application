package guru.framework.springmvcrest.security.model;

import guru.framework.springmvcrest.model.users.Role;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationResponseTest {

    private List<Role> roles = new ArrayList<>();
    private AuthenticationResponse response = new AuthenticationResponse("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjA3MzkwNzQyLCJpYXQiOjE2MDczNTQ3NDJ9.cZSP6zcauxH7EVVOusSx6SQP1-F9NPJJrgcnS4_HRIw", 1, "username", "password", roles);


    @Test
    void setId() {
        response.setId(2);
        assertEquals(2, response.getId());

    }

    @Test
    void setUsername() {
        response.setUsername("test");
        assertEquals("test", response.getUsername());
    }

    @Test
    void setEmail() {
        response.setEmail("test");
        assertEquals("test", response.getEmail());
    }

    List<Role> newRoles = new ArrayList<>();

    @Test
    void setRoles() {
        newRoles.add(new Role());

        response.setRoles(newRoles);
        assertEquals(newRoles, response.getRoles());
    }

    @Test
    void getId() {
        response.setId(2);
        Assert.assertSame(2, response.getId());
    }

    @Test
    void getUsername() {
        response.setUsername("test");
        Assert.assertSame("test", response.getUsername());
    }

    @Test
    void getEmail() {
        response.setEmail("newEmaill");
        Assert.assertSame("newEmaill", response.getEmail());
    }

    @Test
    void getRoles() {
        newRoles.add(new Role());

        response.setRoles(newRoles);
        Assert.assertSame(newRoles, response.getRoles());
    }

    @Test
    void getAccessToke() {
        Assert.assertSame("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjA3MzkwNzQyLCJpYXQiOjE2MDczNTQ3NDJ9.cZSP6zcauxH7EVVOusSx6SQP1-F9NPJJrgcnS4_HRIw", response.getAccessToken());
    }
}