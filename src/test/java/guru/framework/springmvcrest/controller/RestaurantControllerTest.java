//package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.menu.Menu;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.services.RestaurantService;
import guru.framework.springmvcrest.services.RestaurantServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.ArgumentCaptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = RestaurantController.class)
//@WithMockUser
//public class RestaurantControllerTest {



//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private RestaurantService restaurantService;
//
//    Restaurant mockRestaurant = new Restaurant("New Restaurant", "Location 4", "+85845845450", 4, 4, 10, 22, 15, 50);
//
////    String exampleRestaurantJson = "{\"name\":\"New Restaurant\",\"location\":\"Location 4\",\"phoneNumber\":\"+85845845450\",\"rating\":\4\",\"ratingVotes\":\4\",\"openingHour\":\10\",\"closingHour\":\22\",\"minMinsToPrepare\":\15\",\"maxMinsToPreapare\":\50\"}";
//
//    String expectedJSON = "{\"id\":0,\"name\":\"New Restaurant\",\"location\":\"Location 4\",\"phoneNumber\":\"+85845845450\",\"rating\":4.0,\"ratingVotes\":4,\"openingHour\":10,\"closingHour\":22,\"minMinsToPrepare\":15,\"maxMinsToPrepare\":50,\"menus\":null,\"tags\":null}";

//    @Test
//    public void retrieveDataForRestaurant() throws Exception {
//        Mockito.when(
//                restaurantService.findRestaurantById(Mockito.anyLong())).thenReturn(mockRestaurant);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "/restaurants/0").accept(
//                MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        System.out.println(result.getResponse());
//        String expected = " id:0,name:New Restaurant,location:Location 4,phoneNumber:+85845845450,rating:4.0,ratingVotes:4,openingHour:10,closingHour:22,minMinsToPrepare:15,maxMinsToPrepare:50,menus:null,tags:null";
//
//        JSONAssert.assertEquals(expected, result.getResponse()
//                .getContentAsString(), false);
//    }


//    @Test
//    void getAllRestaurants() throws Exception{
//
//        List<Restaurant> restaurants = new ArrayList<>();
//        restaurants.add(mockRestaurant);
//
//        Mockito.when(
//                restaurantService.findAllRestaurants()).thenReturn(restaurants);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "/admin_ui/restaurants/").accept(MediaType.ALL);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        System.out.println(result.getResponse());
//        String expected = "[{id:0,name:New Restaurant,location:Location 4,phoneNumber:+85845845450,rating:4.0,ratingVotes:4,openingHour:10,closingHour:22,minMinsToPrepare:15,maxMinsToPrepare:50,menus:null,tags:null}]";
//
//
//        JSONAssert.assertEquals(expectedJSON,result.getResponse().getContentAsString(),false);
//    }
//}