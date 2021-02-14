package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProfileController {

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
