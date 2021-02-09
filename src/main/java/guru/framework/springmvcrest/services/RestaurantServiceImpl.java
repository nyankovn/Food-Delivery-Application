package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.Tag;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    public static final String BASE_URL = "/admin_ui";

    private final RestaurantRepository restaurantRepository;

    private final ProfileRepository profileRepository;

    private final TagRepository tagRepository;

    private String restaurantWithId = "Restaurant with id ";
    private String doesNotExist = " does not exists";

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, ProfileRepository profileRepository, TagRepository tagRepository) {
        this.restaurantRepository = restaurantRepository;
        this.profileRepository = profileRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getTopRatedRestaurants() {
        return restaurantRepository.getTopRatedRestaurants();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(restaurantWithId + id + doesNotExist));
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant, Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile with id " + profileId + doesNotExist));
        restaurant.setProfile(profile);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(restaurantWithId + id + doesNotExist));

        restaurant.setName(restaurantDetails.getName());
        restaurant.setLocation(restaurantDetails.getLocation());
        restaurant.setPhoneNumber(restaurantDetails.getPhoneNumber());
        restaurant.setOpeningHour(restaurantDetails.getOpeningHour());
        restaurant.setClosingHour(restaurantDetails.getClosingHour());
        restaurant.setMinMinsToPrepare(restaurantDetails.getMinMinsToPrepare());
        restaurant.setMaxMinsToPrepare(restaurantDetails.getMaxMinsToPrepare());

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant assignTagToRestaurant(Long restaurantId, Long tagId, Restaurant restaurantDetails) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(restaurantWithId + restaurantId + doesNotExist));

        List<Tag> tags = restaurantDetails.getTags();

        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new ResourceNotFoundException("Tag with id " + tagId + doesNotExist));

        if (!tags.contains(tag)) {
            tags.add(tag);
        }

        restaurant.setTags(tags);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Map<String, Boolean> deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(restaurantWithId + id + doesNotExist));

        restaurantRepository.delete(restaurant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public Restaurant rateRestaurant(Long id, double rating) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(restaurantWithId + id + doesNotExist));

        restaurant.setRatingVotes();
        restaurant.setRatingTotal(rating);

        restaurantRepository.save(restaurant);

        return restaurant;
    }
}
