package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.repository.RoleRepository;
import guru.framework.springmvcrest.repository.UserRepository;
import guru.framework.springmvcrest.security.JwtUtil;
import guru.framework.springmvcrest.services.ProfileService;
import guru.framework.springmvcrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(ProfileController.BASE_URL)
public class ProfileController {

    public static final String BASE_URL = "/admin_ui";

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profiles")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{role}")
    public List<Profile> getAllProfilesByRole(@PathVariable String role) {
        return profileService.getAllProfilesByRole(role);
    }

    @PostMapping("/{role}")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile, @PathVariable String role) {
        return new ResponseEntity<>(profileService.createProfile(profile, role), HttpStatus.CREATED);
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return new ResponseEntity<>(profileService.getProfileById(id), HttpStatus.OK);
    }

    @PutMapping("/profiles/{id}")
    public ResponseEntity<Profile> updateUser(@PathVariable Long id, @RequestBody Profile userDetails) {
        return new ResponseEntity<>(profileService.updateUser(id, userDetails), HttpStatus.OK);
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(profileService.deleteUser(id), HttpStatus.OK);
    }

    @PostMapping("/profiles/register-restaurant")
    public ResponseEntity<Restaurant> registerRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(profileService.registerRestaurant(restaurant), HttpStatus.CREATED);
    }
}
