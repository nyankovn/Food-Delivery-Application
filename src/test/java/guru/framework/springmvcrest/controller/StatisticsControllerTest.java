package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class StatisticsControllerTest {
    @InjectMocks
    StatisticsController statisticsController;

    @Mock
    RestaurantRepository restaurantRepository;

    @Test
    void testGetRestaurantRevenueById(){
        Double expected = restaurantRepository.getRevenue();
        ResponseEntity<Double> resultt = statisticsController.getRestaurantRevenue();

        assertEquals(ResponseEntity.ok(expected),resultt);
    }
}