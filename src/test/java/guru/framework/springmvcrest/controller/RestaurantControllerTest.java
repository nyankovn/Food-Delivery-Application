package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.services.RestaurantService;
import guru.framework.springmvcrest.services.RestaurantServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantControllerTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService = new RestaurantServiceImpl(restaurantRepository);

//    @Test
//    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
//        Restaurant restaurant=new Restaurant();
//        Mockito
//                .when(restaurantRepository.getForEntity(
//                        “http://localhost:8080/employee/E001”, Employee.class))
//          .thenReturn(new ResponseEntity(emp, HttpStatus.OK));
//
//        Employee employee = empService.getEmployee(id);
//        Assert.assertEquals(emp, employee);
//    }
}