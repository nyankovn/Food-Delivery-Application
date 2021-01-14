package guru.framework.springmvcrest.model.users;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    private Role role=new Role("name");

    List<Profile> profiles=new ArrayList<>();


    @Test
    void getId() {
        role.setId(2);
        assertTrue(role.getId() == 2);
    }

    @Test
    void getName() {
        role.setName("test");
        assertTrue(role.getName() == "test");
    }

    @Test
    void getProfiles() {
        role.setProfiles(profiles);
        assertTrue(role.getProfiles() == profiles);
    }

    @Test
    void setId() {
        role.setId(2);
        assertEquals(2, role.getId());
    }

    @Test
    void setName() {
        role.setName("test");
        assertEquals("test", role.getName());
    }

    @Test
    void setProfiles() {
        role.setProfiles(profiles);
        assertEquals(profiles, role.getProfiles());
    }
}