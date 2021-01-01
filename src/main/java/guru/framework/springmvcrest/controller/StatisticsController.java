package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.repository.ProductRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(StatisticsController.BASE_URL)
public class StatisticsController {
    public static final String BASE_URL = "/admin_ui/statistics";

    private final ProductRepository productRepository;
    private final RestaurantRepository restaurantRepository;

    public StatisticsController(ProductRepository productRepository,RestaurantRepository restaurantRepository) {
        this.productRepository = productRepository;
        this.restaurantRepository=restaurantRepository;
    }

    @GetMapping("/restaurantRevenue/{id}")
    public ResponseEntity<Double> getRestaurantRevenueById(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " does not exists"));

        return ResponseEntity.ok(restaurantRepository.getRevenue());
    }


}
