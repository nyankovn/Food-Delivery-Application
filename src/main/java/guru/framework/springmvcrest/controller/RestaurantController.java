package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.ProfileType;
import guru.framework.springmvcrest.model.users.User;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.repository.UserRepository;
import guru.framework.springmvcrest.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(UserController.BASE_URL)
public class RestaurantController {

    public static final String BASE_URL = "/admin_ui";

    private final RestaurantRepository restaurantRepository;

    @Autowired
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantRepository restaurantRepository, RestaurantService restaurantService) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " does not exists"));

        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/restaurants/mockRestaurant")
    public ResponseEntity<Restaurant> getMockRestaurant() {
        Restaurant mockRestaurant = new Restaurant("New Restaurant", "Location 4", "+85845845450", 4, 4, 10, 22, 15, 50);

        return ResponseEntity.ok(mockRestaurant);
    }


    @PutMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " does not exists"));

        restaurant.setName(restaurantDetails.getName());
        restaurant.setLocation(restaurantDetails.getLocation());
        restaurant.setPhoneNumber(restaurantDetails.getPhoneNumber());
        restaurant.setOpeningHour(restaurantDetails.getOpeningHour());
        restaurant.setClosingHour(restaurantDetails.getClosingHour());
        restaurant.setMinMinsToPrepare(restaurantDetails.getMinMinsToPrepare());
        restaurant.setMaxMinsToPrepare(restaurantDetails.getMaxMinsToPrepare());

        Restaurant updateRestaurant = restaurantRepository.save(restaurant);
        return ResponseEntity.ok(updateRestaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " does not exists"));

        restaurantRepository.delete(restaurant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

