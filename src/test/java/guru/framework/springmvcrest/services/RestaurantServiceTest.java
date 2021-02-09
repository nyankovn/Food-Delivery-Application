package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class RestaurantServiceTest {
    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    @Before
    void init() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void getAllRestaurantsTest() {
//        List<Restaurant> list = new ArrayList<>();
//
//        Restaurant restaurantOne = new Restaurant("Name1", "location", "+123456789", 0, 0, 10, 2, 20, 40);
//        Restaurant restaurantTwo = new Restaurant("Name2", "location", "+123456789", 0, 0, 10, 2, 20, 40);
//        Restaurant restaurantThree = new Restaurant("Name3", "location", "+123456789", 0, 0, 10, 2, 20, 40);
//
//        list.add(restaurantOne);
//        list.add(restaurantTwo);
//        list.add(restaurantThree);
//
//        when(restaurantRepository.findAll()).thenReturn(list);
//        List<Restaurant> restList = restaurantService.findAllRestaurants();
//
//        assertEquals(3, restList.size());
//        verify(restaurantRepository, times(1)).findAll();
//    }

    @Test
    void getRestaurantByIdTest() {
        when(restaurantRepository.findById((long) 0)).thenReturn(java.util.Optional.of(new Restaurant("Name", "location", "+123456789",  10, 2, 20, 40)));

        Restaurant restaurant = restaurantService.getRestaurantById((long) 0);

        assertEquals("Name", restaurant.getName());
        assertEquals("location", restaurant.getLocation());
        assertEquals("+123456789", restaurant.getPhoneNumber());
    }

    @Test
    void getTopRatedRestaurantsTest(){
        List<Restaurant> expected = restaurantRepository.getTopRatedRestaurants();
        List<Restaurant> result = restaurantService.getTopRatedRestaurants();

        assertEquals(expected, result);
    }
}