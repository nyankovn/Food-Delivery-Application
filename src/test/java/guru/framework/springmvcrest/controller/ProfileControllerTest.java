package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.OrderRepository;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ProfileControllerTest {

    @InjectMocks
    ProfileController profileController;

    @Mock
    ProfileRepository profileRepository;

    @Mock
    RoleRepository roleRepository;

    private User user = new User();


    @Test
    public void testGetAllProfiles() {
        // given
        Profile profile1 = new Profile("email", "username", "password", user);
        Profile profile2 = new Profile("email2", "username2", "password2", user);

        List<Profile> profiles = new ArrayList<>();

        profiles.add(profile1);
        profiles.add(profile2);

        when(profileRepository.findAll()).thenReturn(profiles);

        // when
        List<Profile> result = profileController.getAllProfiles();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.get(0).getPassword())
                .isEqualTo(profile1.getPassword());

        assertThat(result.get(1).getUsername())
                .isEqualTo(profile2.getUsername());
    }

    @Test
    void testGetOrderById() {

        when(profileRepository.findById((long) 1)).thenReturn(java.util.Optional.of(new Profile("email", "username", "password", user)));

        ResponseEntity<Profile> profile = profileController.getProfileById((long) 1);

        assertEquals("email", profile.getBody().getEmail());
    }

    @Test
    public void testAddOrder() {
        MockHttpServletRequest request = new MockHttpServletRequest();

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Profile profile1 = new Profile("email", "username", "password", user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("profiles")
                .buildAndExpand(profile1.getId())
                .toUri();

        ResponseEntity<User> responseEntity = ResponseEntity.created(location).build();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

//    @Test
//    public void testGetAllUsersProfilesByRole() {
//        List<Profile> expected = new ArrayList<>();
//        String userRole = "Admin";
//
//        for (Role r : roleRepository.findByName(userRole)) {
//            for (Profile p : r.getProfiles()) {
//                expected.add(p);
//            }
//        }
//
//        List<Profile> result = profileController.getAllUsersProfilesByRole(userRole);
//
//        assertThat(expected).isEqualTo(result);
//    }

//    @Test
//    public void testGetUserRole() {
//        String userRole = "Admin";
//
//        List<Role> expected = roleRepository.findByName(userRole);
//        ResponseEntity<List<Role>> result = profileController.getUserRole(userRole);
//
//        assertThat(expected).isEqualTo(result.getBody());
//    }


}