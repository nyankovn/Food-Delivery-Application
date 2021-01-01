package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Restaurant;
import guru.framework.springmvcrest.model.authentication.AuthenticationRequest;
import guru.framework.springmvcrest.model.authentication.AuthenticationResponse;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.repository.ProfileRepository;
import guru.framework.springmvcrest.repository.RestaurantRepository;
import guru.framework.springmvcrest.security.JwtUtil;
import guru.framework.springmvcrest.services.MyUserDetailsService;
import guru.framework.springmvcrest.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(RestaurantController.BASE_URL)
public class RestaurantController {

    public static final String BASE_URL = "/admin_ui";

    private final RestaurantRepository restaurantRepository;

    private final ProfileRepository profileRepository;

    @Autowired
    private final RestaurantService restaurantService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @Autowired
    private MyUserDetailsService userDetailsService;

    public RestaurantController(RestaurantRepository restaurantRepository, RestaurantService restaurantService, ProfileRepository profileRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantService = restaurantService;
        this.profileRepository = profileRepository;
    }


    @RequestMapping({"/hello"})
    public String Hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate/signin", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        Profile temp = profileRepository.findByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, temp.getId(), temp.getUsername(), temp.getEmail(), temp.getRoles()));
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @GetMapping("/restaurants/top-rated")
    public List<Restaurant> getTopRatedRestaurants() {
        return restaurantService.getTopRatedRestaurants();
    }


    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " does not exists"));

        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/restaurants/mockRestaurant")
    public ResponseEntity<Restaurant> getMockRestaurant() {
        Restaurant mockRestaurant = new Restaurant("New Restaurant", "Location 4", "+85845845450", 4, 4, 10, 22, 15, 50);

        return ResponseEntity.ok(mockRestaurant);
    }


    @PutMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " does not exists"));

        restaurant.setName(restaurantDetails.getName());
        restaurant.setLocation(restaurantDetails.getLocation());
        restaurant.setPhoneNumber(restaurantDetails.getPhoneNumber());
        restaurant.setOpeningHour(restaurantDetails.getOpeningHour());
        restaurant.setClosingHour(restaurantDetails.getClosingHour());
        restaurant.setMinMinsToPrepare(restaurantDetails.getMinMinsToPrepare());
        restaurant.setMaxMinsToPrepare(restaurantDetails.getMaxMinsToPrepare());

        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " does not exists"));

        restaurantRepository.delete(restaurant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

