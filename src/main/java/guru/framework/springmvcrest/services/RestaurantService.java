package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Restaurant;

import java.util.List;

public interface RestaurantService {

     List<Restaurant> findAllRestaurants();

     Restaurant findRestaurantById(Long id);

     List<Restaurant> getTopRatedRestaurants();
}
