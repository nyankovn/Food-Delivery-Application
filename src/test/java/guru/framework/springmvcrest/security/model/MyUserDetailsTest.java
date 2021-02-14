package guru.framework.springmvcrest.security.model;

import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.security.model.MyUserDetails;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyUserDetailsTest {

    private Profile profile = new Profile();
    private MyUserDetails userDetails = new MyUserDetails(profile);

    @Test
    void getAuthorities() {
        List<Role> roles = profile.getRoles();
        List<SimpleGrantedAuthority> expected = new ArrayList<>();

        for (Role s : roles) {
            expected.add(new SimpleGrantedAuthority(s.getName()));
        }

        Collection<? extends GrantedAuthority> result = userDetails.getAuthorities();

        assertEquals(expected, result);
    }

    @Test
    void getPassword() {
        Assert.assertSame(profile.getPassword(), userDetails.getPassword());
    }

    @Test
    void getUsername() {
        Assert.assertSame(profile.getUsername(), userDetails.getUsername());
    }

    @Test
    void isAccountNonExpired() {
        Assert.assertSame(true, userDetails.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        Assert.assertSame(true, userDetails.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        Assert.assertSame(true, userDetails.isCredentialsNonExpired());

    }

    @Test
    void isEnabled() {
        Assert.assertSame(profile.isEnabled(), userDetails.isEnabled());
    }
}