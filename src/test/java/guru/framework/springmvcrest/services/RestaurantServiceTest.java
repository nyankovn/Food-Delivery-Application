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
public class RestaurantServiceTest {
    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllRestaurantsTest() {
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
    public void getRestaurantByIdTest() {
        when(restaurantRepository.findById((long) 0)).thenReturn(java.util.Optional.of(new Restaurant("Name", "location", "+123456789", 0, 0, 10, 2, 20, 40)));

        Restaurant restaurant = restaurantService.findRestaurantById((long) 0);

        assertEquals("Name", restaurant.getName());
        assertEquals("location", restaurant.getLocation());
        assertEquals("+123456789", restaurant.getPhoneNumber());
    }

//    @MockBean
//    private RestaurantServiceImpl restaurantService;
//
//    @Test
//    void findAllTestNrOfElements() {
//        when(restaurantService.findAllRestaurants()).thenReturn(Stream.of(
//                new Restaurant(),
//                new Restaurant()
//        ).collect(Collectors.toList()));
//        assertEquals(2, restaurantService.findAllRestaurants().size());
//    }

//    @Test
//    void findAllTest() {
//        when(restaurantService.findAllRestaurants()).thenReturn(Stream.of(
//                new Restaurant("Name", "location", "+123456789", 0, 0, 10, 2, 20, 40),
//                new Restaurant("SecondName", "location", "+123456789", 0, 0, 10, 2, 20, 40)
//        ).collect(Collectors.toList()));
//
//        String exampleRestaurantJson = "[Restaurant(id=0, name=Name, location=location, phoneNumber=+123456789, rating=0.0, ratingVotes=0, openingHour=10, closingHour=2, minMinsToPrepare=20, maxMinsToPrepare=40, menus=null, tags=null, orders=null), Restaurant(id=0, name=SecondName, location=location, phoneNumber=+123456789, rating=0.0, ratingVotes=0, openingHour=10, closingHour=2, minMinsToPrepare=20, maxMinsToPrepare=40, menus=null, tags=null, orders=null)]";
//
//        assertEquals(exampleRestaurantJson, restaurantService.findAllRestaurants().toString()
//        );
//    }


//    This is NOT WORKING
//    @Test
//    public void findByIdTest() {
//        //Arange
//        Restaurant restaurant = new Restaurant("Name", "location", "+123456789", 0, 0, 10, 2, 20, 40),
//
//
//        Mockito.when(restaurantService.findRestaurantById((long) 0)).thenReturn(Optional.of(restaurant));
//        assertThat( .findById(DISH_ID)).isEqualTo(dish);
//
//    }
}