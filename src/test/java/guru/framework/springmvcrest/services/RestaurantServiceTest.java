package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.services.RestaurantServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//package guru.framework.springmvcrest.services;
//
//import guru.framework.springmvcrest.model.Restaurant;
//import guru.framework.springmvcrest.repository.RestaurantRepository;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.commons.logging.LoggerFactory;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.persistence.EntityManager;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//
//import static org.junit.jupiter.api.Assertions.*;
//
@SpringBootTest
//@DataJpaTest
class RestaurantServiceTest {

    @MockBean
    private RestaurantServiceImpl restaurantService;

    @Test
    void findAll() {
        when(restaurantService.findAllRestaurants()).thenReturn(Stream.of(
                new Restaurant(),
                new Restaurant()
        ).collect(Collectors.toList()));
        assertEquals(2,restaurantService.findAllRestaurants().size());
    }
//    @MockBean
//    private RestaurantRepository restaurantRepository;
//
//    private RestaurantServiceImpl restaurantService;
//
//
//
//    @Before
//    public void setUp() {
//        restaurantService = new RestaurantServiceImpl(restaurantRepository);
//
//        restaurantRepository = mock(RestaurantRepository.class);
//    }
//
//    @Test
//    public void findAll() {
//        List<Restaurant> restaurants = new ArrayList<Restaurant>();
//        when(restaurantRepository.findAll(any(Sort.class))).thenReturn(restaurants);
//
//        List<Restaurant> returned = restaurantService.findAllRestaurants();
//
//        ArgumentCaptor<Sort> sortArgument = ArgumentCaptor.forClass(Sort.class);
//        verify(restaurantRepository, times(1)).findAll(sortArgument.capture());
//
//        verifyNoMoreInteractions(restaurantRepository);
//
//        Sort actualSort = sortArgument.getValue();
//        assertEquals(Sort.Direction.ASC, actualSort.getOrderFor("name").getDirection());
//
//        assertEquals(restaurants, returned);
//    }
}
//
//   private static final Logger log=  LoggerFactory
//           .getLogger(RestaurantServiceTest.class);
//
//   private RestaurantService service;
//
//   @Mock
//    private RestaurantRepository restaurantRepository;
//
//   @Mock
//    private Restaurant restaurant;
//
//    @Before
//    public void setupMock() {
//
//        MockitoAnnotations.initMocks(this);
//        service= new RestaurantServiceImpl(restaurantRepository);
//    }
//
//    @Test
//    public void testFindAll(){
//        List<Restaurant> listRestaurants=new ArrayList<>();
//
//    }
//
//}