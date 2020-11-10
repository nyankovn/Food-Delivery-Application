package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findRestaurantById(Long id) {
        return restaurantRepository.findById(id).get();
    }
}
