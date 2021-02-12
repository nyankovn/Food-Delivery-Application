package guru.framework.springmvcrest.model.users;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    private Role role = new Role("name");

    List<Profile> profiles = new ArrayList<>();

    @Test
    void getName() {
        role.setName("test");
        Assert.assertSame("test", role.getName());
    }

    @Test
    void getProfiles() {
        role.setProfiles(profiles);
        Assert.assertSame(profiles, role.getProfiles());
    }

    @Test
    void getId() {
        role.setId(1);
        Assert.assertSame(role.getId(), 1);
    }

    @Test
    void setId() {
        role.setId(1);
        assertEquals(1, role.getId());
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