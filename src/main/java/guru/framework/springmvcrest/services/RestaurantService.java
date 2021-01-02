package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

     List<Restaurant> findAllRestaurants();

     Restaurant findRestaurantById(Long id);

     Optional<List<Restaurant>> getTopRatedRestaurants();
}
