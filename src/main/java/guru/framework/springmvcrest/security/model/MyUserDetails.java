package guru.framework.springmvcrest.security.model;

import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
public class MyUserDetails implements UserDetails {

    private Profile profile;

    public MyUserDetails(Profile profile) {
        this.profile = profile;
    }

    @Override
    @Transactional
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = profile.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role s : roles) {
            authorities.add(new SimpleGrantedAuthority(s.getName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return profile.getPassword();
    }

    @Override
    public String getUsername() {
        return profile.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return profile.isEnabled();
    }
}
