package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(StatisticsController.BASE_URL)
public class StatisticsController {
    public static final String BASE_URL = "/statistics";

    private final RestaurantRepository restaurantRepository;

    public StatisticsController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository=restaurantRepository;
    }

    @GetMapping("/restaurantRevenue/{id}")
    public ResponseEntity<Double> getRestaurantRevenue() {
        return ResponseEntity.ok(restaurantRepository.getRevenue());
    }
}
