package guru.framework.springmvcrest.service;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.users.Profile;

import java.util.List;
import java.util.Map;

public interface ProfileService {

    List<Profile> getAllProfiles();

    List<Profile> getAllProfilesByRole(String role);

    Profile createProfile(Profile profile, String role);

    Profile getProfileById(Long id);

    Profile updateUser(Long id, Profile userDetails);

    Map<String, Boolean> deleteUser(Long id);

    Restaurant registerRestaurant(Restaurant restaurant);
}
