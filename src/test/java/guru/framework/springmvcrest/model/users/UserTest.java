package guru.framework.springmvcrest.model.users;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user = new User("firstname", "lastname", "+98412654", "address");

    @Test
    void getFirstName() {
        user.setFirstName("test");
        Assert.assertSame("test",user.getFirstName());
    }

    @Test
    void getLastName() {
        user.setLastName("test");
        Assert.assertSame("test",user.getLastName());
    }

    @Test
    void getPhoneNumber() {
        user.setPhoneNumber("test");
        Assert.assertSame("test",user.getPhoneNumber());
    }

    @Test
    void getAddress() {
        user.setAddress("test");
        Assert.assertSame("test",user.getAddress());
    }

    List<Profile> profiles = new ArrayList<>();

    @Test
    void getProfiles() {
        user.setProfiles(profiles);
        Assert.assertSame(profiles,user.getProfiles());
    }


    @Test
    void setId() {
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    void setFirstName() {
        user.setFirstName("test");
        assertEquals("test", user.getFirstName());
    }

    @Test
    void setLastName() {
        user.setLastName("test");
        assertEquals("test", user.getLastName());
    }

    @Test
    void setPhoneNumber() {
        user.setPhoneNumber("test");
        assertEquals("test", user.getPhoneNumber());
    }

    @Test
    void setAddress() {
        user.setAddress("test");
        assertEquals("test", user.getAddress());
    }

    @Test
    void setProfiles() {
        user.setProfiles(profiles);
        assertEquals(profiles, user.getProfiles());
    }
}