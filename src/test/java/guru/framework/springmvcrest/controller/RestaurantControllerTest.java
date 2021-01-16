package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Order;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.repository.OrderRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.services.RestaurantService;
import guru.framework.springmvcrest.services.RestaurantServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class RestaurantControllerTest {

    @InjectMocks
    RestaurantController restaurantController;

    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    @Test
    void testMockRestaurant() {
        Restaurant mockRestaurant = new Restaurant("New Restaurant", "Location 4", "+85845845450", 4, 4, 10, 22, 15, 50);

        ResponseEntity<Restaurant> expected =ResponseEntity.ok(mockRestaurant);
        ResponseEntity<Restaurant> result =restaurantController.getMockRestaurant();

        assertEquals(expected.getBody().getClosingHour(), result.getBody().getClosingHour());
        assertEquals(expected.getBody().getName(), result.getBody().getName());
        assertEquals(expected.getBody().getLocation(), result.getBody().getLocation());
    }

    @Test
    public void testGetAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();

        Restaurant restaurantOne = new Restaurant("Name1", "location", "+123456789", 0, 0, 10, 2, 20, 40);
        Restaurant restaurantTwo = new Restaurant("Name2", "location", "+123456789", 0, 0, 10, 2, 20, 40);
        Restaurant restaurantThree = new Restaurant("Name3", "location", "+123456789", 0, 0, 10, 2, 20, 40);

        list.add(restaurantOne);
        list.add(restaurantTwo);
        list.add(restaurantThree);

        when(restaurantRepository.findAll()).thenReturn(list);
        List<Restaurant> restList = restaurantService.findAllRestaurants();

        assertEquals(3, restList.size());
        verify(restaurantRepository, times(1)).findAll();
    }

    @Test
    void testGetRestaurantById() {
        when(restaurantRepository.findById((long) 0)).thenReturn(java.util.Optional.of(new Restaurant("Name", "location", "+123456789", 0, 0, 10, 2, 20, 40)));

        ResponseEntity<Restaurant> restaurant = restaurantController.getRestaurantById((long) 0);

        assertEquals("Name", restaurant.getBody().getName());
        assertEquals("location", restaurant.getBody().getLocation());
        assertEquals("+123456789", restaurant.getBody().getPhoneNumber());
    }

    @Test
    void getTopRatedRestaurantsTest(){
        List<Restaurant> expected = restaurantRepository.getTopRatedRestaurants();
        List<Restaurant> result = restaurantService.getTopRatedRestaurants();

        assertEquals(expected, result);
    }
}