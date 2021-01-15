package guru.framework.springmvcrest.model.users;

import guru.framework.springmvcrest.model.menu.Product;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyUserDetailsTest {

    private Profile profile=new Profile();
    private MyUserDetails userDetails = new MyUserDetails(profile);

    @Test
    void getAuthorities() {
        List<Role> roles = profile.getRoles();
        List<SimpleGrantedAuthority> expected = new ArrayList<>();

        for (Role s : roles) {
            expected.add(new SimpleGrantedAuthority(s.getName()));
        }

        Collection<? extends GrantedAuthority>  result = userDetails.getAuthorities();

        assertEquals(expected, result);
    }

    @Test
    void getPassword() {
        assertTrue(userDetails.getPassword() == profile.getPassword());
    }

    @Test
    void getUsername() {
        assertTrue(userDetails.getUsername() == profile.getUsername());
    }

    @Test
    void isAccountNonExpired() {
        assertTrue(userDetails.isAccountNonExpired() == true);
    }

    @Test
    void isAccountNonLocked() {
        assertTrue(userDetails.isAccountNonLocked() == true);
    }

    @Test
    void isCredentialsNonExpired() {
        assertTrue(userDetails.isCredentialsNonExpired() == true);
    }

    @Test
    void isEnabled() {
        assertTrue(userDetails.isEnabled() == profile.isEnabled());
    }
}