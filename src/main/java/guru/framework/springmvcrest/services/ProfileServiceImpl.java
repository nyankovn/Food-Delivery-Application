package guru.framework.springmvcrest.services;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfileServiceImpl implements ProfileService {


    private final ProfileRepository profileRepository;
    private final RestaurantRepository restaurantRepository;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private JwtUtil jwtTokenUtil;

    public ProfileServiceImpl(ProfileRepository profileRepository, RestaurantRepository restaurantRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.profileRepository = profileRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    private String profileWithId = "Profile with id ";
    private String doesNotExist = " does not exists";

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public List<Profile> getAllProfilesByRole(String role) {
        List<Profile> profiles = new ArrayList<>();
        for (Profile p : profileRepository.findAll()) {
            if (p.getRoles().contains(roleRepository.findByName(role))) {
                profiles.add(p);
            }
        }
        return profiles;
    }

    @Override
    public Profile createProfile(Profile profile, String role) {
        Role r = roleRepository.findByName(role);
        List<Role> roles = new ArrayList<>();
        roles.add(r);
        profile.setRoles(roles);
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(profileWithId + id + doesNotExist));
    }

    @Override
    public Profile updateUser(Long id, Profile userDetails) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(profileWithId + id + doesNotExist));

        profile.setEmail(userDetails.getEmail());
        profile.setPassword(userDetails.getPassword());

        return profileRepository.save(profile);
    }

    @Override
    public Map<String, Boolean> deleteUser(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(profileWithId + id + doesNotExist));

        User user = profile.getProfileUser();
        List<Profile> updatedList = user.getProfiles();
        updatedList.remove(profile);
        user.setProfiles(updatedList);

        List<Role> updatedRoles = new ArrayList<>();
        profile.setRoles(updatedRoles);

        userRepository.save(user);
        profileRepository.delete(profile);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public Restaurant registerRestaurant(Restaurant restaurant) {
        //takes the id of the logged in user, and set it as restaurant owner
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");

        String jwt = token.substring(7);

        String username = jwtTokenUtil.extractUsername(jwt);
        Profile profile = profileRepository.findByUsername(username);
        restaurant.setProfile(profile);
        return restaurantRepository.save(restaurant);
    }
}
