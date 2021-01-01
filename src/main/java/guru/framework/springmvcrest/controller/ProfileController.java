package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RoleRepository;
import guru.framework.springmvcrest.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(ProfileController.BASE_URL)
public class ProfileController {

    public static final String BASE_URL = "/admin_ui";

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public ProfileController(ProfileRepository profileRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/profiles")
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @GetMapping("/{userRole}")
    public List<Profile> getAllUsersProfilesByRole(@PathVariable String userRole) {
        List<Profile> profile = new ArrayList<>();
        for (Role r : roleRepository.findByName(userRole)) {
            for (Profile p : r.getProfiles()) {
                profile.add(p);
            }
        }
        return profile;
    }

    @PostMapping("/{userRole}")
    @ResponseStatus(HttpStatus.CREATED)
    public Profile createAdmin(@RequestBody Profile user) {
        return profileRepository.save(user);
    }

    @GetMapping("/{userRole}/{id}")
    public ResponseEntity<Profile> getUserById(@PathVariable Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile with id " + id + " does not exists"));

        return ResponseEntity.ok(profile);
    }

    @GetMapping("/{userRole}/role")
    public ResponseEntity<List<Role>> getUserRole(@PathVariable String userRole) {
        List<Role> role = roleRepository.findByName(userRole);

        return ResponseEntity.ok(role);
    }

    @PutMapping("/{userRole}/{id}")
    public ResponseEntity<Profile> updateUser(@PathVariable Long id, @RequestBody Profile userDetails) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile with id " + id + " does not exists"));

        profile.setEmail(userDetails.getEmail());
        profile.setPassword(userDetails.getPassword());

        Profile updateUser = profileRepository.save(profile);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{userRole}/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile with id " + id + " does not exists"));

        User user = profile.getProfileUser();
        List<Profile> updatedList = user.getProfiles();
        updatedList.remove(profile);
        user.setProfiles(updatedList);

        List<Role> updatedRoles = profile.getRoles();
        updatedRoles.removeAll(updatedRoles);
        profile.setRoles(updatedRoles);

        userRepository.save(user);
        profileRepository.delete(profile);


        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
