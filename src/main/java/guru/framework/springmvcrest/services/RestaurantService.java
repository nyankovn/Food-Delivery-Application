package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RestaurantService {

     List<Restaurant> findAllRestaurants();

     Restaurant findRestaurantById(Long id);

     List<Restaurant> getTopRatedRestaurants();
}
