package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(Long id);

    List<Restaurant> getTopRatedRestaurants();

    Restaurant createRestaurant(Restaurant restaurant, Long profileId);

    Restaurant updateRestaurant(Long id, Restaurant restaurantDetails);

    Restaurant assignTagToRestaurant(Long restaurantId, Long tagId, Restaurant restaurantDetails);

    Map<String, Boolean> deleteRestaurant(Long id);

    Restaurant rateRestaurant(Long id, double rating);
}
