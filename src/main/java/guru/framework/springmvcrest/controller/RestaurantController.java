package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurants/top-rated")
    public List<Restaurant> getTopRatedRestaurants() {
        return restaurantService.getTopRatedRestaurants();
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return new ResponseEntity<>(restaurantService.getRestaurantById(id), HttpStatus.OK);
    }

    @PostMapping("/restaurants/assign-restaurant/{profileId}")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant, @PathVariable Long profileId) {
        return new ResponseEntity<>(restaurantService.createRestaurant(restaurant, profileId), HttpStatus.CREATED);
    }


    @PutMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
        return new ResponseEntity<>(restaurantService.updateRestaurant(id, restaurantDetails), HttpStatus.OK);
    }

    @PutMapping("/restaurants/{restaurantId}/tags/{tagId}")
    public ResponseEntity<Restaurant> assignTagToRestaurant(@PathVariable Long restaurantId, @PathVariable Long tagId, @RequestBody Restaurant restaurantDetails) {
        return new ResponseEntity<>(restaurantService.assignTagToRestaurant(restaurantId, tagId, restaurantDetails), HttpStatus.OK);
    }

    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRestaurant(@PathVariable Long id) {
        return new ResponseEntity<>(restaurantService.deleteRestaurant(id), HttpStatus.OK);

    }

    @PutMapping("/restaurants/{id}/rate/{rating}")
    public ResponseEntity<Restaurant> rateRestaurant(@PathVariable Long id, @PathVariable double rating) {
        return new ResponseEntity<>(restaurantService.rateRestaurant(id, rating), HttpStatus.OK);
    }
}

