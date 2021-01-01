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

    private final RestaurantRepository restaurantRepository;

    public StatisticsController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository=restaurantRepository;
    }

    @GetMapping("/restaurantRevenue/{id}")
    public ResponseEntity<Double> getRestaurantRevenueById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantRepository.getRevenue());
    }


}
