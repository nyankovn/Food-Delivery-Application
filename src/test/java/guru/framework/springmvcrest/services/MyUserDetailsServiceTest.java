package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.ProfileRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MyUserDetailsServiceTest {

    @InjectMocks
    MyUserDetailsService userDetailsService;

    @Mock
    ProfileRepository profileRepository;

    @Before
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsername() {
        String username="username";

        User user=new User();
        when(profileRepository.findByUsername(username)).thenReturn(new Profile("email","username","password",user));

        UserDetails result = userDetailsService.loadUserByUsername(username);

        assertEquals("username", result.getUsername());
        assertEquals("password", result.getPassword());
    }
}